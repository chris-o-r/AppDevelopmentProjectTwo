package ie.chris.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ie.chris.dao.IProjectDao;
import ie.chris.domain.Project;
import ie.chris.services.ProjectService;

@Controller
public class MainController {
	@Autowired
	ProjectService projectService; 
	
	@GetMapping(value= {"/", "/index"})
	public String handleIndexRequest(Model model)
	{
		List<Project> projects = projectService.listInAlphabeticalOrder(); 
		model.addAttribute("projects", projects);
		return "index";
	}	
	
}
