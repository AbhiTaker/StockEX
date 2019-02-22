package com.stockex.mvc.dao;

import javax.sql.DataSource;

import com.stockex.mvc.entities.Account;

public interface AccountDAO {
	
	public void setDataSource(DataSource ds);
	
	public void insertAccount(String email, float cash);
	
	public float getCash(String email);
	
	public Account getAccount(String email);

}
