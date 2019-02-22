package com.stockex.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stockex.mvc.entities.Account;


public class AccountMapper implements RowMapper<Account> {

	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Account account = new Account();
		account.setCash(rs.getFloat("cash"));
		account.setValue(rs.getFloat("cash"));
		
		return account;
	}

}
