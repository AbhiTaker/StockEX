package com.stockex.mvc.services;

import java.util.*;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.stockex.mvc.dao.StockDAOJDBCImpl;
import com.stockex.mvc.entities.Stock;


@Service
public class StockInfoService {
	
	@Autowired
	private StockDAOJDBCImpl stockJDBC;
	
	private static com.google.gson.JsonParser PARSER = new com.google.gson.JsonParser();
	protected static Gson GSON = new Gson();
	
	public void parseJson(String symbol) {
		
		RestTemplate restTemplate = new RestTemplate();
		String getUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
				+ symbol + "&apikey=KKJQAFAXP7GQMUKJ"; 
		String json = restTemplate.getForObject(getUrl, String.class) ;
		
		JsonElement jsonElement = PARSER.parse(json);
	    JsonObject rootObject = jsonElement.getAsJsonObject();
	    
	    JsonObject dates = rootObject.get("Time Series (Daily)").getAsJsonObject();
	   
	    String lastDate = dates.keySet().iterator().next();
	   
	    JsonObject prop = dates.get(lastDate).getAsJsonObject();
	    
	    stockJDBC.updatePrice(symbol, prop.get("4. close").getAsFloat());
		
	}
	
	public void stockInfoService() {
		
		List<Stock> Stocks = stockJDBC.listStocks();
		
		for(Stock stock: Stocks) {
			String symbol = stock.getSymbol();
			parseJson(symbol);
		}
		
	
	}

}
