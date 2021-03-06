package com.stockex.mvc.controllers;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.stockex.mvc.entities.User;
import com.stockex.mvc.services.AuthService;
import com.stockex.mvc.services.StockInfoService;

@Controller
@SessionAttributes("email")
public class LoginController {
	
	@Autowired
	private AuthService auth;
	
	@Autowired 
	StockInfoService s;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public ModelAndView logIn(HttpSession session) {
		
		//s.stockInfoService();
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView logIn(HttpSession session, @RequestParam String usertype, 
			@RequestParam String email, @RequestParam String password) {
		
		ModelAndView model = new ModelAndView();
		User newUser = new User();
		newUser.setUsertype(usertype);
		newUser.setEmail(email);
		newUser.setPassword(password);
		
		// Authenticating the login details of user 
		if(auth.authenticate(newUser)) {
			if(Objects.equals(usertype, "admin")) {
				model.setViewName("redirect:addbroker");
			}
			else if(Objects.equals(usertype, "broker")) {
				model.setViewName("redirect:alltrade");
			}
			else {
				model.setViewName("redirect:portfolio");
			}
			session.setAttribute("email", email);
			return model;
		}
		
		model.addObject("error", "Incorrect Credentials");
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET )
	public ModelAndView registerUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("register");
		return model;
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST )
	public ModelAndView registerUser(HttpSession session, @RequestParam String first_name, 
			@RequestParam String last_name, @RequestParam String email,
			@RequestParam String password, @RequestParam String confirm_password) {
		
		ModelAndView model = new ModelAndView();
		
		if(!Objects.equals(password, confirm_password)) {
			model.setViewName("redirect:register");
			return model;
		}
		

		User newUser = new User();
		newUser.setUsertype("client");
		newUser.setFirstName(first_name);
		newUser.setLastName(last_name);
		newUser.setEmail(email);
		newUser.setPassword(password);
		
		// Validating the non-existence of New User using AuthService
		if(auth.registerUser(newUser)) {
			session.setAttribute("email", email);
			model.setViewName("redirect:portfolio");
			return model;
		}
		
		model.addObject("error", "registration unsuccessful");
		model.setViewName("redirect:register");
		return model;
		
	}
	
}
