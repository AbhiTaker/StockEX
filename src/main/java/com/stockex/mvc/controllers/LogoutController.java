package com.stockex.mvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	
	@RequestMapping(value = "/logout")
	public ModelAndView logOut(HttpSession session) {
		
		ModelAndView model = new ModelAndView();

		session.invalidate();
		
		model.setViewName("redirect:login");
		return model;
	}
}
