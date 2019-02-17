package com.stockex.mvc.entities;

public class Stock {
	
	private String symbol;
	private String name;
	private float price;
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public Float getPrice() {
		return price;
	}
	

}
