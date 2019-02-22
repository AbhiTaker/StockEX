package com.stockex.mvc.controllers;

import java.util.List;
import java.util.Objects;

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

import com.stockex.mvc.dao.OrderDAOJDBCImpl;
import com.stockex.mvc.dao.StockDAOJDBCImpl;
import com.stockex.mvc.dao.UserDAOJDBCImpl;
import com.stockex.mvc.entities.Account;
import com.stockex.mvc.entities.Order;
import com.stockex.mvc.entities.Stock;
import com.stockex.mvc.entities.User;
import com.stockex.mvc.services.AccountService;
import com.stockex.mvc.services.AuthService;

@Controller
@SessionAttributes("email")
public class UserController {
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	@Autowired
	private AuthService auth;
	
	@Autowired
	private AccountService acc;
	
	@Autowired
	private StockDAOJDBCImpl stockJDBC;
	
	@Autowired
	private OrderDAOJDBCImpl orderJDBC;
	
	@RequestMapping(value = "/portfolio", method = RequestMethod.GET )
	public ModelAndView UserDashboard(HttpSession session) {
		

		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
		String email = (String)session.getAttribute("email");

		User user = userJDBC.getUser(email);
		model.addObject("usertype", user.getUsertype());
		model.addObject("first_name", user.getFirstName());
		
		if(Objects.equals(user.getUsertype(), "client")) {
			Account account = acc.getInformation(email);
			List<Order> orders = orderJDBC.getPortfolio(email);
			
			if(orders!=null) {
				for(Order order: orders) {
					
					Stock stock = stockJDBC.getStock(order.getOrderSymbol());
					order.setCompany(stock.getName());
					order.setCurrentprice(stock.getPrice());
					account.setValue(account.getValue() + order.getQuantity()*stock.getPrice());
				}
			}
			account.setBuying_power(account.getCash() + (account.getValue() - account.getCash())*(float)0.5);
			/*
			System.out.println(account.getValue());
			System.out.println(account.getCash());
			System.out.println(account.getBuying_power());
			*/
			model.addObject("account", account);
			model.addObject("orders", orders);
		}
		
		model.setViewName("portfolio");
		return model;
	}
	
	@RequestMapping(value = "/addbroker", method = RequestMethod.POST )
	public ModelAndView AddUser(HttpSession session, @RequestParam String first_name, 
			@RequestParam String last_name, @RequestParam String email,
			@RequestParam String password, @RequestParam String confirm_password) {
		
		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
		User user = userJDBC.getUser((String)session.getAttribute("email"));
		model.addObject("usertype", user.getUsertype());
		model.addObject("first_name", user.getFirstName());
		
		if(!Objects.equals(password, confirm_password)) {
			model.addObject("result", "Registration unsuccessful");
			model.setViewName("redirect:addbroker");
			return model;
		}
		
		User newUser = new User();
		newUser.setUsertype("broker");
		newUser.setFirstName(first_name);
		newUser.setLastName(last_name);
		newUser.setEmail(email);
		newUser.setPassword(password);
		
		// Validating the non-existence of New User using AuthService
		if(auth.registerUser(newUser)) {
			session.setAttribute("email", email);
			model.addObject("result", "Broker Successfully Registered");
		}
		else {
			model.addObject("result", "Registration unsuccessful");
		}
		
		model.setViewName("addbroker");
		return model;
	}
	
	@RequestMapping(value = "/addbroker", method = RequestMethod.GET )
	public ModelAndView AddUser(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
		User user = userJDBC.getUser((String)session.getAttribute("email"));
		
		model.addObject("usertype", user.getUsertype());
		model.addObject("first_name", user.getFirstName());
		model.setViewName("addbroker");
		return model;
	}
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET )
	public ModelAndView UserProfile(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
		String email = (String)session.getAttribute("email");
		model.addObject("first_name", userJDBC.getUsername(email));
		model.setViewName("myprofile");
		return model;
	}
	
	@RequestMapping(value = "/editprofile", method = RequestMethod.GET )
	public ModelAndView EditProfile(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
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
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
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
