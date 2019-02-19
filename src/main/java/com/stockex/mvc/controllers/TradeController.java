package com.stockex.mvc.controllers;

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

import com.stockex.mvc.dao.StockDAOJDBCImpl;
import com.stockex.mvc.dao.UserDAOJDBCImpl;
import com.stockex.mvc.entities.Order;
import com.stockex.mvc.entities.Stock;
import com.stockex.mvc.entities.User;
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
		
		ModelAndView model = fillModel(session);
		List<Stock> stockList = stockJDBC.listStocks(); 
		model.addObject("stockList", stockList);
		
		model.setViewName("trade");
		return model;
	}
	
	@RequestMapping(value = "/trade", method = RequestMethod.POST )
	public ModelAndView Trade(HttpSession session, @RequestParam String symbol,
			@RequestParam String type, @RequestParam int quantity, @RequestParam float price) {
		
		ModelAndView model = fillModel(session);
		
		System.out.println(symbol);
		System.out.println(type);
		System.out.println(quantity);
		System.out.println(price);
		
		Order order = new Order();
		order.setOrderSymbol(symbol);
		order.setType(type);
		order.setQuantity(quantity);
		order.setPrice(price);
		
		Stock stock = stockJDBC.getStock(symbol);
		order.setComission(30);
		order.setTotal(order.getQuantity()*order.getPrice() + order.getCommission());
		model.addObject("order", order);
		model.addObject("stock", stock);
		model.setViewName("previewOrder");
		return model;
	}
	
	@RequestMapping(value = "/previewOrder", method = RequestMethod.POST )
	public ModelAndView previewOrder(HttpSession session,  @RequestParam int quantity, @RequestParam float price) {
		
		ModelAndView model = fillModel(session);
		
		model.setViewName("redirect:trade");
		return model;
	}
	
	@RequestMapping(value = "/opentrade", method = RequestMethod.GET)
	public ModelAndView openTrade(HttpSession session) {
		
		ModelAndView model = fillModel(session);
		
		model.setViewName("opentrade");
		return model;
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ModelAndView History(HttpSession session) {
		
		ModelAndView model = fillModel(session);
		
		model.setViewName("history");
		return model;
	}

}
