package ie.chris;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ie.chris.services.*;
import ie.chris.dao.IRoleDao;
import ie.chris.domain.*;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	ProjectService projectService; 
	
	@Autowired
	UserService userService;
	
	@Autowired
	PledgeService pledgeService;
	
	@Autowired
	IRoleDao roleDao;
	
	@Autowired
	PasswordEncoder passwordEncoder; 
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		

//		//Saving the user
		User user = new User();
		user.setFirstName("Chris"); 
		user.setSecondName("O'Riordan"); 	
		user.setEmail("chris.o.riordan11@gmail.com");
		user.setPassword("password");

		user.setEnabled(true);
		userService.saveUser(user);
//		
//		User user2 = new User(); 	
//		user2.setFirstName("User"); 
//		user2.setSecondName("33432"); 
//		user2.setEmail("user@email.com");
//		user2.setPassword(passwordEncoder.encode("password"));
//		user2.setRole(roleTwo);
//		user2.setEnabled(true);
//		userService.saveUser(user2);
//		
		
/*		
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
		
		//Adding Pledges
		Pledge pledge = new Pledge(); 
		pledge.setUser(user);
		pledge.setProject(project);
		pledge.setPledged(30.0);
		pledgeService.savePledge(pledge);
		 
		Project projectTwo = new Project();
		projectTwo.setName("Project Two");
		now = LocalDateTime.now();  
		projectTwo.setDateCreated(now.toString());
		projectTwo.setInfo("This is the descrption for project Two");
		projectTwo.setGoal(10000.0);
		projectTwo.setCreator(user);
		projectService.save(projectTwo);
		
*/		
	}

}
