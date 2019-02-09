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

@Controller
@SessionAttributes("email")
public class UserController {
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET )
	public ModelAndView UserDashboard(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		String email = (String)session.getAttribute("email");
		model.addObject("first_name", userJDBC.getUsername(email));
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
	public ModelAndView EditProfile(HttpSession session, @RequestParam String first_name) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("editprofile");
		return model;
	}

}
