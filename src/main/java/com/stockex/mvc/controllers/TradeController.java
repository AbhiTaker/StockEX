package com.stockex.mvc.controllers;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

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

import com.stockex.mvc.dao.AccountDAOJDBCImpl;
import com.stockex.mvc.dao.OrderDAOJDBCImpl;
import com.stockex.mvc.dao.StockDAOJDBCImpl;
import com.stockex.mvc.dao.UserDAOJDBCImpl;
import com.stockex.mvc.entities.Order;
import com.stockex.mvc.entities.Stock;
import com.stockex.mvc.entities.User;
import com.stockex.mvc.services.AuthService;
import com.stockex.mvc.services.OrderService;
import com.stockex.mvc.services.StockInfoService;

@Controller
@SessionAttributes("email")
public class TradeController {
	
	@Autowired
	private StockDAOJDBCImpl stockJDBC;
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	@Autowired
	private StockInfoService stockService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AccountDAOJDBCImpl accountJDBC;
	
	@Autowired
	private OrderDAOJDBCImpl orderJDBC;
	
	@Autowired
	private AuthService auth;
	
	
	private ModelAndView fillModel(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		String email = (String)session.getAttribute("email");
		
		User newUser = userJDBC.getUser(email);
		model.addObject("usertype", newUser.getUsertype());
		model.addObject("email", newUser.getEmail());
		model.addObject("first_name", newUser.getFirstName());
		model.addObject("last_name", newUser.getLastName());
		
		return model;
	}
	
	@RequestMapping(value = "/trade", method = RequestMethod.GET )
	public ModelAndView Trade(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
		model = fillModel(session);
		List<Stock> stockList = stockJDBC.listStocks(); 
		model.addObject("stockList", stockList);
		
		model.setViewName("trade");
		return model;
	}
	
	@RequestMapping(value = "/trade", method = RequestMethod.POST )
	public ModelAndView Trade(HttpSession session, @RequestParam String symbol,
			@RequestParam String type, @RequestParam int quantity, @RequestParam float price) {
		
		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
		model = fillModel(session);
		
		String email = (String)session.getAttribute("email");
		
		Order order = new Order();
		order.setOrderSymbol(symbol);
		order.setType(type);
		order.setQuantity(quantity);
		order.setPrice(price);
		
		Stock stock = stockJDBC.getStock(symbol);
		order.setTotal(order.getQuantity()*order.getPrice());
		
		model.addObject("order", order);
		model.addObject("stock", stock);
		
		orderService.placeOrder(order, email);
		if(accountJDBC.getCash(email) < order.getPrice()) {
			model.addObject("error", "ORDER IS WRNOG");
		}
		model.setViewName("previewOrder");
		return model;
	}
	
	@RequestMapping(value = "/previewOrder", method = RequestMethod.POST )
	public ModelAndView previewOrder(HttpSession session,  @RequestParam int quantity, @RequestParam float price) {
		
		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
		model = fillModel(session);
		
		model.setViewName("redirect:trade");
		return model;
	}
	
	@RequestMapping(value = "/opentrade", method = RequestMethod.GET)
	public ModelAndView openTrade(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
		model = fillModel(session);
		
		String email = (String)session.getAttribute("email");
		
		List<Order> orders = orderJDBC.getOrder(email);
		
		model.addObject("orders", orders);
		model.setViewName("opentrade");
		return model;
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ModelAndView History(HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		if(!auth.validUser(session)) {
			model.setViewName("redirect:login");
			return model;
		}
		
		model = fillModel(session);
		
		String email = (String)session.getAttribute("email");
		
		List<Order> orders = orderJDBC.getAllOrder(email);
		
		model.addObject("orders", orders);
		model.setViewName("history");
		return model;
	}

}
