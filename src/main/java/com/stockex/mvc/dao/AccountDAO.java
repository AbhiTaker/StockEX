package com.stockex.mvc.dao;

import javax.sql.DataSource;

public interface AccountDAO {
	
	public void setDataSource(DataSource ds);
	
	public void insertAccount(String email, float cash);
	
	public float getCash(String email);

}
