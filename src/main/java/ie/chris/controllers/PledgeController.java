package ie.chris.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.chris.domain.Pledge;
import ie.chris.domain.Project;
import ie.chris.domain.User;
import ie.chris.services.PledgeService;
import ie.chris.services.ProjectService;
import ie.chris.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class PledgeController {
	
	@Autowired
	PledgeService pledgeService;
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/pledge")
	public String handelCreatePledge(@Valid Pledge pledge, BindingResult binding, RedirectAttributes redirectAttributes) {
		
		if(binding.hasErrors()) {
		    return "redirect:project/"+pledge.getProject().getId();
		}
		
		//@ TODO Remove this step with actual login code 
		User user = userService.findUserById(1);
		pledge.setUser(user);
		if (pledgeService.savePledge(pledge)) {
			
			return "redirect:project/"+pledge.getProject().getId();
		}else {
			return "/error";
			//@ TODO Return Error 
		}
		
	}
}
