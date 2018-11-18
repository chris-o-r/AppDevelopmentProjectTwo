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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class User {
	
	@Column(nullable=false, unique=true)
	private String name; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany( fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Project> pledges = new ArrayList<Project>(); 
	
	@OneToMany(mappedBy="creator", fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Project> projects = new ArrayList<Project>();
	
	public User() { 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
}
