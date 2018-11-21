package ie.chris.domain;

import java.sql.Time;
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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Project {
	
	@Column(nullable=false)
	private String name; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne( fetch=FetchType.EAGER)
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private User creator; 
	
	@ManyToMany(mappedBy="pledges", fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<User> pledgies = new ArrayList<User>();
	
	@Column(nullable = false)
	private String info; 
	
	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

	public double getCurrentAmmount() {
		return currentAmmount;
	}

	public void setCurrentAmmount(double currentAmmount) {
		this.currentAmmount = currentAmmount;
	}
	@Column(nullable = false)
	private String dateCreated;
	
	@Column(nullable = false)
	@DecimalMin("1.0") 
	private double goal;
	
	@Column
	private double currentAmmount; 
	
	 public List<User> getPledgies() {
		return pledgies;
	}

	public void setPledgies(List<User> pledgies) {
		this.pledgies = pledgies;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Project() {
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
	public void setCreator(User user) {
		this.creator = user;
	}
	public User getCreator() {
		return this.creator; 
	}

}
