package com.stockex.mvc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.stockex.mvc.entities.Account;

public class AccountDAOJDBCImpl implements AccountDAO{

	private DataSource accountdataSource;
	private JdbcTemplate jdbcTemplate;
	  
	public void setDataSource(DataSource ds) {
		accountdataSource = ds;
	    jdbcTemplate = new JdbcTemplate(accountdataSource);
	 }

	public void insertAccount(String email, float cash) {
		String sql = "insert into account (email, cash) values (?, ?)";
		jdbcTemplate.update(sql, email, cash);
	}

	public float getCash(String email) {
		String sql = "select cash from account where email = ?";
		Account account  = jdbcTemplate.queryForObject(sql, new Object[]{email}, new AccountMapper());
	    return account.getCash();
	}
	
	public Account getAccount(String email) {
		String sql = "select cash from account where email = ?";
		Account account  = jdbcTemplate.queryForObject(sql, new Object[]{email}, new AccountMapper());
	    return account;
	}

}
