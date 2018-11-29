		package ie.chris.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

import ie.chris.domain.Pledge;
import ie.chris.domain.Project;
import ie.chris.domain.User;
import ie.chris.services.IPledgeService;
import ie.chris.services.IUserService;
import ie.chris.services.PledgeService;
import ie.chris.services.ProjectService;
import ie.chris.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class PledgeController {
	
	@Autowired
	IPledgeService pledgeService;
	
	@Autowired
	IUserService userService;
	
	
	@PostMapping("/pledge")
	public String handelCreatePledge(@Valid Pledge pledge, BindingResult binding, RedirectAttributes redirectAttributes) {
		
		if(binding.hasErrors()) {
		    return "redirect:project/"+pledge.getProject().getId();
		}
		
		User user = userService.getCurrentUser(); 
		pledge.setUser(user);
		
		if (pledgeService.savePledge(pledge)) {
			
			return "redirect:project/"+pledge.getProject().getId();
		}else {
			return "error"; 
		}	
	}
	
	@GetMapping("/pledge/details/{id}")
	public String handleRequestForPledgeDetailsPage(Model model, @PathVariable(name = "id") int id) {
		List<Pledge> pledges = pledgeService.findAllPledgesByProjectId(1);
		if (pledges != null && pledges.size() > 0) {
			model.addAttribute("pledges", pledges);
			return "pledgeDetails";
		}
		
		return "pledgeDetails";
	}
}
