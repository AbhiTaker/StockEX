package com.stockex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("email")
public class UserController {
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET )
	public String UserDashboard(@ModelAttribute("email") String email, Model model) {
		
		model.addAttribute("username", userJDBC.getUsername(email));
		return "dashboard";
	}

}
