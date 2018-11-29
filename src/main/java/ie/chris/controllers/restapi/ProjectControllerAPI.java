package ie.chris.controllers.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.chris.dao.IProjectDao;
import ie.chris.domain.Project;

@RestController
@RequestMapping("/api")
public class ProjectControllerAPI {
	
	@Autowired 
	IProjectDao projectDao; 
	
	@GetMapping("/project/active")
	public List<Project> activeProject(){
		List<Project> projects = null; 
		projects = projectDao.findAllActiveProjects(); 
		return projects; 
	}
	
	
}
