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
import com.stockex.mvc.entities.Stock;
import com.stockex.mvc.entities.User;
import com.stockex.mvc.services.StockInfoService;

@Controller
@SessionAttributes("email")
public class StockController {
	
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
	
	@RequestMapping(value = "/addstock", method = RequestMethod.GET )
	public ModelAndView AddStock(HttpSession session) {
		
		ModelAndView model = fillModel(session);
		model.setViewName("addstock");
		return model;
	}
	
	@RequestMapping(value = "/addstock", method = RequestMethod.POST )
	public ModelAndView AddStock(HttpSession session, @RequestParam String symbol,
			@RequestParam String name) {
		
		ModelAndView model = fillModel(session);
		Stock stock = new Stock();
		stock.setSymbol(symbol);
		stock.setName(name);
		stockJDBC.insertStock(stock);
		
		stockService.parseJson(symbol);
		model.setViewName("addstock");
		return model;
	}
	
	@RequestMapping(value = "/research", method = RequestMethod.GET)
	public ModelAndView stockResearch(HttpSession session) {
		
		ModelAndView model = fillModel(session);
		List<Stock> stocks = stockJDBC.listStocks();
		
		model.addObject("stocks", stocks);
		model.setViewName("research");
		return model;
	}

}
