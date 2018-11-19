package ie.chris.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.chris.domain.User;
import ie.chris.services.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService; 
	
	//Gets the sign up page
	@GetMapping(value= {"/signup"})
	public String handleSignUpPageRequest(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	
	/**
	 * Handles put requests for adding a new user
	 * @param user
	 * @param binding
	 * @return a new page
	 * TODO add logic for confirm password 
	 */
	@PostMapping(value= {"/user"})
	public String handleAddCountyRequest(@Valid User user, BindingResult binding, RedirectAttributes redirectAttributes) {
		if (binding.hasErrors()) {
			return "signup"; 
		}
		
		if (userService.saveUser(user)) {
			//Redirect home and authenticate
			return "redirect:index"; 
		} 
		return null;
		
	}
}
