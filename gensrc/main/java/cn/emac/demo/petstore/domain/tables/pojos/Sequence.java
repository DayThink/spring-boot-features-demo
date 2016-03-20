/**
 * This class is generated by jOOQ
 */
package cn.emac.demo.petstore.domain.tables.pojos;


import javax.annotation.Generated;
import java.io.Serializable;


/**
 * Inventory
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequence implements Serializable {

	private static final long serialVersionUID = 1364864828;

	private String  name;
	private Integer nextid;

	public Sequence() {}

	public Sequence(Sequence value) {
		this.name = value.name;
		this.nextid = value.nextid;
	}

	public Sequence(
		String  name,
		Integer nextid
	) {
		this.name = name;
		this.nextid = nextid;
	}

	public String getName() {
		return this.name;
	}

	public Sequence setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getNextid() {
		return this.nextid;
	}

	public Sequence setNextid(Integer nextid) {
		this.nextid = nextid;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Sequence (");

		sb.append(name);
		sb.append(", ").append(nextid);

		sb.append(")");
		return sb.toString();
	}
}