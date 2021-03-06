package cn.emac.demo.petstore.controllers;

import cn.emac.demo.petstore.common.JsonResult;
import cn.emac.demo.petstore.common.exceptions.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.String.format;
import static org.springframework.http.HttpHeaders.CACHE_CONTROL;

/**
 * 即便产生异常，返回的响应码始终应是200
 *
 * @author Emac
 * @since 2017-04-22
 */
@Slf4j
@ControllerAdvice
public class ApiGlobalController extends AbstractJsonpResponseBodyAdvice {

    private static final String NO_STORE = "no-store";

    public ApiGlobalController() {
        super("callback");
    }

    /**
     * 捕获所有异常
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public JsonResult handleAllException(HttpServletRequest request, HttpServletResponse response, Throwable e) {
        return _handleException(request, response, e);
    }

    /**
     * 处理异常的响应
     */
    private JsonResult _handleException(HttpServletRequest request, HttpServletResponse response, Throwable error) {
        response.setHeader(CACHE_CONTROL, NO_STORE);

        // 获取异常源
        while (error.getCause() != null) {
            if (error instanceof CommonException && !(error.getCause() instanceof CommonException)) {
                break;
            }
            error = error.getCause();
        }

        String errorMsg = error.getMessage();

        String rootCauseMessage = ExceptionUtils.getRootCauseMessage(error);
        if (!(StringUtils.containsIgnoreCase(rootCauseMessage, "Broken pipe")
                || StringUtils.containsIgnoreCase(rootCauseMessage, "Connection reset by peer"))) {
            // 忽略客户端断开连接导致的异常
            log.error("Exception occurred: " + errorMsg + ". [URL=" + request.getRequestURI() + "]", error);
        }

        if (error instanceof IllegalArgumentException) {
            // 一般是Assert异常
            return JsonResult.error(errorMsg);
        } else if (error instanceof MethodArgumentNotValidException) {
            // 数据校验异常
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) error;
            FieldError fieldError = ex.getBindingResult().getFieldError();
            if (StringUtils.isNotBlank(fieldError.getDefaultMessage())) {
                return JsonResult.error(format("%s: %s", fieldError.getField(), fieldError.getDefaultMessage()));
            }
        }
        // 默认返回服务异常
        return JsonResult.error(errorMsg);
    }
}
