package com.stockex.mvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.stockex.mvc.dao.UserDAOJDBCImpl;
import com.stockex.mvc.entities.User;
import com.stockex.mvc.services.AuthService;

@Controller
@SessionAttributes("email")
public class UserController {
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	@Autowired
	private AuthService auth;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET )
	public ModelAndView UserDashboard(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		String email = (String)session.getAttribute("email");

		User user = userJDBC.getUser(email);
		model.addObject("usertype", user.getUsertype());
		model.addObject("first_name", user.getFirstName());
		
		model.setViewName("dashboard");
		return model;
	}
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET )
	public ModelAndView UserProfile(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		String email = (String)session.getAttribute("email");
		model.addObject("first_name", userJDBC.getUsername(email));
		model.setViewName("myprofile");
		return model;
	}
	
	@RequestMapping(value = "/editprofile", method = RequestMethod.GET )
	public ModelAndView EditProfile(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		String email = (String)session.getAttribute("email");
		
		User newUser = userJDBC.getUser(email);
		model.addObject("usertype", newUser.getUsertype());
		model.addObject("email", newUser.getEmail());
		model.addObject("first_name", newUser.getFirstName());
		model.addObject("last_name", newUser.getLastName());
		
		model.setViewName("editprofile");
		return model;
	}
	
	@RequestMapping(value = "/editprofile", method = RequestMethod.POST )
	public ModelAndView EditProfile(HttpSession session, @RequestParam String first_name,
			@RequestParam String last_name, @RequestParam String new_password, 
			@RequestParam String password) {
		
		ModelAndView model = new ModelAndView();
		// redirecting back to GET method
		model.setViewName("redirect:editprofile");
		
		String email = (String)session.getAttribute("email");
		
		User user = userJDBC.getUser(email);
		user.setEmail(email);
		user.setFirstName(first_name);
		user.setLastName(last_name);
		user.setPassword(password);
		
		// current Password verification
		if(!auth.authenticate(user)) {
			return model;
		}
		
		if(!(new_password.isEmpty())) {
			user.setPassword(new_password);
		}
		
		userJDBC.updateUser(user);
		 
		return model;
	}

}
