package ie.chris;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ie.chris.services.*;
import ie.chris.domain.*;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	ProjectService projectService; 
	
	@Autowired
	UserService userService;
	
	@Autowired
	PledgeService pledgeService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		User user = new User();
		user.setFirstName("Chris"); 
		user.setSecondName("O'Riordan"); 
		user.setEmail("chris@email.com");
		user.setPassword("password");
		userService.saveUser(user);
		
		user = new User();
		user.setFirstName("User"); 
		user.setSecondName("33432"); 
		user.setEmail("user@email.com");
		user.setPassword("password");
		userService.saveUser(user);
		
		//Adding Data For Projects 
		Project project = new Project();
		project.setName("Project One");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		project.setDateCreated(now.toString());
		project.setInfo("This is the descrption");
		project.setGoal(10000.0);
		project.setCreator(user);
		projectService.save(project);
		
		Pledge pledge = new Pledge(); 
		pledge.setUser(user);
		pledge.setProject(project);
		pledge.setPledged(30.0);

		 
		Project projectTwo = new Project();
		projectTwo.setName("Project Two");
		now = LocalDateTime.now();  
		projectTwo.setDateCreated(now.toString());
		projectTwo.setInfo("This is the descrption for project Two");
		projectTwo.setGoal(10000.0);
		projectTwo.setCreator(user);
		projectService.save(projectTwo);
		
		
	}

}
