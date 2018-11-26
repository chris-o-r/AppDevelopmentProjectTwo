package ie.chris.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.chris.domain.Pledge;
import ie.chris.domain.Project;
import ie.chris.domain.User;
import ie.chris.services.PledgeService;
import ie.chris.services.ProjectService;
import ie.chris.services.UserService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService; 
	
	@Autowired
	UserService userService; 
	
	@Autowired 
	PledgeService pledgeService;
	
	@GetMapping("/project/{id}") 
	public String showAProjectById(@PathVariable(name="id") int id, Model model)
	{
		Project project  = projectService.findProject(id);
		if (project == null)
		{
			model.addAttribute("id", id);
			return "notfounderror";
		}
		//Adding Project To The Model
		model.addAttribute("project", project);
		
		//Adding the pledge for the pledge form 
		Pledge pledge = new Pledge(); 
		pledge.setProject(project);
		model.addAttribute("pledge", pledge);
		return "viewaproject";
	}
	
	@GetMapping("/project/create")
	public String handleRequestForCreateAProjectPage(Model model) {
		Project project = new Project(); 
		model.addAttribute("project", project); 
		return "createaproject"; 
	}
	
	@PostMapping("/project")
	public String createProject(@Valid Project project, BindingResult binding, RedirectAttributes redirectAttributes) {
		
		if (binding.hasErrors())
		{
			return "createaproject";
		}
		
		User user = userService.findUserById(1);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		
		
		project.setCreator(user);
		project.setDateCreated(dtf.format(now));
		
		if (projectService.save(project)) {
			return "/index";
		}
		
		return null;
		
	}
	
}
