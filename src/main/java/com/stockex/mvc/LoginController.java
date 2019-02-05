package com.stockex.mvc;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@Autowired
	AuthService auth;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(Model model, @RequestParam String usertype, 
			@RequestParam String email, @RequestParam String password) {
		System.out.println(usertype);
		System.out.println(email);
		System.out.println(password);
		User newUser = new User();
		newUser.setUsertype(usertype);
		newUser.setEmail(email);
		newUser.setPassword(password);
		
		if(auth.authenticate(newUser)) {
			model.addAttribute("username", usertype);
			return "dashboard";
		}
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET )
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST )
	public String registerUser(@RequestParam String first_name, 
			@RequestParam String last_name, @RequestParam String email,
			@RequestParam String password, @RequestParam String confirm_password) {
		
		System.out.println(first_name);
		System.out.println(last_name);
		System.out.println(email);
		System.out.println(password);
		
		if(!Objects.equals(password, confirm_password))
			return "redirect:register";
		

		User newUser = new User();
		newUser.setUsertype("client");
		newUser.setFirstName(first_name);
		newUser.setLastName(last_name);
		newUser.setEmail(email);
		newUser.setPassword(password);
		if(auth.registerUser(newUser))
			return "dashboard";
		else
			return "redirect:register";
		
	}
	
}
