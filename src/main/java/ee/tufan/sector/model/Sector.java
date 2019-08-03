package ee.tufan.sector.model;


import javax.persistence.*;
import java.text.MessageFormat;

@Entity
@Table(name = "sector")
public class Sector {

	private final static String FORMAT_NO = "({0}) {1}";
	private final static String FORMAT_SEPARATOR = "{0} / {1}";

	@Id
	@Column(name = "sector_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Sector parent;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFullName() {
		String fullName = getName();
		Sector parent = this.parent;
		while (parent != null) {
			fullName = MessageFormat.format(FORMAT_SEPARATOR, parent.name, fullName);
			parent = parent.parent;
		}
		return fullName;
	}

	public String getFullNameWithNo() {
		String fullName = getFullName();
		return MessageFormat.format(FORMAT_NO, getId().toString(), fullName);
	}

}
