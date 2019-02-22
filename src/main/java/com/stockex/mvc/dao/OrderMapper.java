package com.stockex.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.stockex.mvc.entities.Order;

public class OrderMapper implements RowMapper<Order>{
	
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order order = new Order();
		order.setOrderId(rs.getInt("orderId"));
		order.setOrderSymbol(rs.getString("symbol"));
		order.setType(rs.getString("type"));
		order.setPrice(rs.getFloat("stock_price"));
		order.setQuantity(rs.getInt("quantity"));
		order.setTotal(order.getQuantity()*order.getPrice());
		order.setDate(rs.getDate("orderdate"));
		order.setTime(rs.getTime("ordertime"));
		
		return order;
	}
}
