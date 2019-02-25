package com.stockex.mvc.dao;

import java.util.List;
import javax.sql.DataSource;
import com.stockex.mvc.entities.Order;

public interface OrderDAO {
	
	public void setDataSource(DataSource ds);
	
	public void placeOrder(Order order, String email);
	
	public List<Order> getPlacedOrder(String email);
	
	public Order getOrderDetail(int orderId);
	
	public List<Order> getAllOrder(String email);
	
	public void executeOrder(Order order);
	
	public List<Order> getPortfolio(String email);
	
	public List<Order> getActiveOrders();
	

}
