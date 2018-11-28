package ie.chris.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping(value = "/login") 
		public String handleSignInPageRequest() {
		return "signin";
	}
	
	@GetMapping(value="/logout")
	public String register(HttpSession session){
		session.removeAttribute("user");
		return "index";
	}

	@GetMapping(value ="/403")
	public String handle403ErrorPageRequest() {
		return "403";
	}
}
