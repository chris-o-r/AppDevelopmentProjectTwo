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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Value;

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
	
	@OneToMany(mappedBy="project", cascade= CascadeType.ALL)
	private List<Pledge> pledges = new ArrayList<Pledge>();
	
	@Column(nullable = false)
	private String info; 
	
	@Column(nullable = false)
	@DecimalMin("1.0") 
	private double goal;
	
	
	@Column()
	@Value("${true}")
	private boolean status; 

	public Project() {
	 }
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
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
	
	@Column
	private double currentAmmount; 
	
	public List<Pledge> getPledgies() {
		return pledges;
	}

	public void setPledgies(List<Pledge> pledges) {
		this.pledges = pledges;
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
