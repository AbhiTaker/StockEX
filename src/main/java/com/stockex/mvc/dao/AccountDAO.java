package com.stockex.mvc.dao;

import javax.sql.DataSource;

import com.stockex.mvc.entities.Account;

public interface AccountDAO {
	
	public void setDataSource(DataSource ds);
	
	public void insertAccount(String email, float cash);
	
	public float getCash(String email);
	
	public float getCash(int OrderId);
	
	public Account getAccount(String email);
	
	public void updateAccount(int orderId, float cash);

}
