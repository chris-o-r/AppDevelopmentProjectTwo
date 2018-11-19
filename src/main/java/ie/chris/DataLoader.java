package ie.chris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ie.chris.services.ProjectService;
import ie.chris.services.UserService;
import ie.chris.domain.Project;
import ie.chris.domain.User;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	ProjectService projectService; 
	
	@Autowired
	UserService userService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		User user = new User();
		user.setFirstName("User"); 
		user.setSecondName("One"); 
		user.setEmail("email@lki.com ");
		user.setPassword("password");
		userService.saveUser(user);
		
		//Adding Data For Projects 
		Project project = new Project();
		project.setName("Project One");
		
		project.setCreator(user);
		projectService.save(project);
		
		Project test = projectService.findProject(1);
		
	}

}
