package ie.chris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ie.chris.domain.Project;
import ie.chris.services.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService; 
	
	@GetMapping("/project/{id}") 
	public String showAProjectById(@PathVariable(name="id") int id, Model model)
	{
		Project project  = projectService.findProject(id);
		if (project == null)
		{
			model.addAttribute("id", id);
			return "notfounderror";
		}
		model.addAttribute("project", project);
		return "project";
	}
	
}
