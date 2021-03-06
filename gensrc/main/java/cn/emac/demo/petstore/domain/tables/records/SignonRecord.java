/*
 * This file is generated by jOOQ.
*/
package cn.emac.demo.petstore.domain.tables.records;


import cn.emac.demo.petstore.domain.tables.Signon;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Cadastro de usuários
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SignonRecord extends UpdatableRecordImpl<SignonRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1370365025;

    /**
     * Setter for <code>jpetstore.signon.username</code>.
     */
    public SignonRecord setUsername(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>jpetstore.signon.username</code>.
     */
    public String getUsername() {
        return (String) get(0);
    }

    /**
     * Setter for <code>jpetstore.signon.password</code>.
     */
    public SignonRecord setPassword(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>jpetstore.signon.password</code>.
     */
    public String getPassword() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Signon.SIGNON.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Signon.SIGNON.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignonRecord value1(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignonRecord value2(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SignonRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SignonRecord
     */
    public SignonRecord() {
        super(Signon.SIGNON);
    }

    /**
     * Create a detached, initialised SignonRecord
     */
    public SignonRecord(String username, String password) {
        super(Signon.SIGNON);

        set(0, username);
        set(1, password);
    }
}
