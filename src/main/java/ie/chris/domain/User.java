package ie.chris.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	@Size(min=3, max=20)
	private String firstName; 
	
	@Column(nullable = false)
	@Size(min=3, max=20)
	private String secondName;
	
	@Column(unique = true, nullable = false)
	@Email
	private String email; 
	
	@Column(nullable = false)
	private String password; 
	
	@OneToOne
	@JoinColumn(name = "roleEmail", nullable = false)
	private Role role;
	
	@Column
	boolean enabled;
	
	@OneToMany(mappedBy="user", cascade= CascadeType.ALL)
	private List<Pledge> pledges = new ArrayList<Pledge>(); 
	
	@OneToMany(mappedBy="creator", fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Project> projects = new ArrayList<Project>();
	
	public User() { 
	}
	
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean userEnabled) {
		this.enabled = userEnabled;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//
//	public List<Pledge> getPledges() {
//		return pledges;
//	}
//
//	public void setPledges(List<Pledge> pledges) {
//		this.pledges = pledges;
//	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
}
