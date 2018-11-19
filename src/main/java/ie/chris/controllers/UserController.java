package ie.chris.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ie.chris.domain.User;
import ie.chris.services.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService; 
	
	@GetMapping(value= {"/signup"})
	public String handleSignUpPageRequest() {
		return "signup";
	}
	
	@PostMapping(value= {"/user"})
	public String handleAddCountyRequest(@Valid User user, BindingResult binding) {
		if (binding.hasErrors()) {
			return "signup"; 
		}
		
		if (userService.saveUser(user)) {
			//Redirect home and authenticate
			return "/"; 
		}
		return null;
		
	}
}
