package ee.tufan.sector.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -3584150858539695521L;

	@Id
	@Column(name = "username")
	@Size(max = 100)
	private String username;

	@Column(name = "password")
	@Size(max = 100)
	private String password;

	@Column(name = "name")
	@Size(max = 100)
	private String name;

	@ManyToMany
	@JoinTable(
			name = "user_sector",
			joinColumns = @JoinColumn(name = "username"),
			inverseJoinColumns = @JoinColumn(name = "sector_id"))
	Set<Sector> userSectorList;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Sector> getUserSectorList() {
		return this.userSectorList;
	}

	public void setUserSectorList(Set<Sector> userSectorList) {
		this.userSectorList = userSectorList;
	}

}
