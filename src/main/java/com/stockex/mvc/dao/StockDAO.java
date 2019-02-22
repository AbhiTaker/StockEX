package com.stockex.mvc.dao;

import java.util.List;
import javax.sql.DataSource;
import com.stockex.mvc.entities.Stock;

public interface StockDAO {
	
	  // set database connection
	  public void setDataSource(DataSource ds);
	  
	  // create a new Stock record in the stock table
	  public void insertStock(Stock stock);
	  
	  // get a stock with the passed symbol
	  public Stock getStock(String symbol);
	  
	  public String getUsername(String email);
	  
	  // get all the stocks from the stock table
	  public List<Stock> listStocks();
	  
	  // update a stock given the Stock
	  public void updatePrice(String symbol, float price);
	  
	  public String getCompany(String symbol);
	  
}
