package com.stockex.mvc.entities;

import java.sql.Time;
import java.util.Date;

public class Order {
	
	private String orderSymbol;
	private int orderId;
	private String type;
	private int quantity;
	private float price;
	private float commission;
	private float total;
	private Date date;
	private Time time;
	private String company;
	private float Currentprice;
	
	public float getCurrentprice() {
		return Currentprice;
	}
	public void setCurrentprice(float currentprice) {
		Currentprice = currentprice;
	}
	public String getOrderSymbol() {
		return orderSymbol;
	}
	public void setOrderSymbol(String orderSymbol) {
		this.orderSymbol = orderSymbol;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getCommission() {
		return commission;
	}
	public void setComission(float commission) {
		this.commission = commission;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
