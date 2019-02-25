package com.stockex.mvc.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockex.mvc.dao.AccountDAOJDBCImpl;
import com.stockex.mvc.dao.OrderDAOJDBCImpl;
import com.stockex.mvc.entities.Order;

@Service
public class OrderService {
	

	@Autowired
	private OrderDAOJDBCImpl orderJDBC;
	
	@Autowired
	private AccountDAOJDBCImpl accountJDBC;
	
	public boolean placeOrder(Order order, String email) {
		
		orderJDBC.placeOrder(order, email);
		
		return true;
	}
	
	public boolean executeOrder(int OrderId, String email) {
		
		Order order = orderJDBC.getOrderDetail(OrderId);
		
		if(Objects.equals(order.getType(), "BUY")) {
			
			float cash = accountJDBC.getCash(OrderId);
			if(cash < order.getTotal()) {
				return false;
			}
			
			accountJDBC.updateAccount(OrderId, cash - order.getTotal());
			orderJDBC.executeOrder(order);
			return true;
		}
		else {
			return false;
		}
	}
	
}
