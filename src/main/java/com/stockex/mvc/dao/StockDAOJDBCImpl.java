package com.stockex.mvc.dao;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.stockex.mvc.entities.Stock;

public class StockDAOJDBCImpl implements StockDAO {

	private DataSource stockdataSource;
	private JdbcTemplate jdbcTemplate;
	  
	public void setDataSource(DataSource ds) {
		stockdataSource = ds;
	    jdbcTemplate = new JdbcTemplate(stockdataSource);
	 }
	  
	// INCOMPLETE
	public void insertStock(Stock stock) {
		
		String sql = "insert into stock (symbol, name) values (?, ?)";
	    jdbcTemplate.update(sql, stock.getSymbol(), stock.getName());
	    System.out.println("Created New Stock");
		
	}

	public Stock getStock(String symbol) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Stock> listStocks() {
		
		String sql = "select * from stock";
	    List<Stock> stocks = jdbcTemplate.query(sql, new StockMapper());
	    return stocks;
	}

	public void updatePrice(String symbol, float price) {
		
		String sql = "update stock set price = ? where symbol = ?";
	    jdbcTemplate.update(sql, price, symbol);
	    System.out.println("STOCK " + symbol + " price " + price);
	}

}
