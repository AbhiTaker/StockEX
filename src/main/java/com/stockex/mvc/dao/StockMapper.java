package com.stockex.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stockex.mvc.entities.Stock;

public class StockMapper implements RowMapper<Stock> {

	public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Stock stock = new Stock();
		stock.setSymbol(rs.getString("symbol"));
		stock.setName(rs.getString("name"));
		stock.setPrice(rs.getFloat("price"));
		
		return stock;
	}

}
