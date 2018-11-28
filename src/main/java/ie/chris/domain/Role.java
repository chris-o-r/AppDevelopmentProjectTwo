package ie.chris.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	String email;
	
	@Column
	String description;
	
	public Role() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String roleDescription) {
		this.description = roleDescription;
	}
	
	
	
}
