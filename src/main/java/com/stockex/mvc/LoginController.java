package com.stockex.mvc;

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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET )
	public String register() {
		return "register";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(Model model, @RequestParam String usertype, 
			@RequestParam String mail, @RequestParam String password) {
		System.out.println(usertype);
		System.out.println(mail);
		System.out.println(password);
		User newUser = new User();
		newUser.setUsertype(usertype);
		newUser.setEmail(mail);
		newUser.setPassword(password);
		
		if(auth.authenticate(newUser)) {
			model.addAttribute("username", usertype);
			return "dashboard";
		}
		return "login";
	}
	
}
