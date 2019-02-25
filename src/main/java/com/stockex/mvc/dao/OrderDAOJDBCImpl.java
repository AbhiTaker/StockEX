package com.stockex.mvc.dao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.stockex.mvc.entities.Order;

public class OrderDAOJDBCImpl implements OrderDAO{
	
	private DataSource orderdataSource;
	private JdbcTemplate jdbcTemplate;
	  
	public void setDataSource(DataSource ds) {
		orderdataSource = ds;
	    jdbcTemplate = new JdbcTemplate(orderdataSource);
	 }

	public void placeOrder(Order order, String email) {
		
		long millis=System.currentTimeMillis();  
		Date date = new java.sql.Date(millis);
		Time time = new java.sql.Time(millis);
		String sql = "insert into orders (type, symbol, quantity, stock_price, status, orderdate, ordertime) values (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, order.getType(), order.getOrderSymbol(), order.getQuantity(), order.getPrice(), "WAIT", date, time);
		
		sql = "select * from orders where type = ? and symbol = ? and quantity = ?  and stock_price = ? and status = ? and orderdate = ? and ordertime = ?";
		order = jdbcTemplate.queryForObject(sql, new OrderMapper(), order.getType(), order.getOrderSymbol(), order.getQuantity(), order.getPrice(), "WAIT", date, time);
		
		sql = "insert into transaction (email, orderId) values(?, ?)";
		jdbcTemplate.update(sql, email, order.getOrderId());
		System.out.println("this one");
		System.out.println(order.getOrderId());
	}

	public List<Order> getOrder(String email) {
		
		try {
			String sql = "select * from orders where orderId in (select orderID from transaction where email = ?) and status = ?";
			List<Order> orders = jdbcTemplate.query(sql, new OrderMapper(), email, "WAIT");
			return orders;
		}
		catch (Exception e){
			return null;
		}
	}

	public void executeOrder(Order order) {
		
		String sql = "update orders set status = ? where orderId = ?";
		jdbcTemplate.update(sql, "SUCCESS", order.getOrderId());
		
	}

	public List<Order> getPlacedOrder(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order getOrderDetail(int orderId) {
		
		String sql = "select * from orders where orderId = ?";
		Order order = jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new OrderMapper());
		return order;
	}

	public List<Order> getAllOrder(String email) {
		
		String sql = "select * from orders where orderId in (select orderID from transaction where email = ?)";
		List<Order> orders = jdbcTemplate.query(sql, new Object[]{email}, new OrderMapper());
		return orders;
	}
	
	public List<Order> getPortfolio(String email) {
		
		try {
			String sql = "select * from orders where orderId in (select orderID from transaction where email = ?) and type = ? and status = ?";
			
			List<Order> orders = jdbcTemplate.query(sql, new OrderMapper(), email, "BUY", "SUCCESS");
			return orders;
		}
		catch (Exception e){
			return null;
		}
	}
	
	public List<Order> getActiveOrders() {
		try {
			String sql = "select * from orders where status = ?";
			List<Order> orders = jdbcTemplate.query(sql, new Object[]{"WAIT"}, new OrderMapper());
			return orders;
		}
		catch (Exception e){
			return null;
		}
	}
	

}
