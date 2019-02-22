package com.stockex.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockex.mvc.dao.AccountDAOJDBCImpl;
import com.stockex.mvc.dao.StockDAOJDBCImpl;
import com.stockex.mvc.entities.Account;

@Service
public class AccountService {
	
	@Autowired
	private StockDAOJDBCImpl stockJDBCImpl;
	
	@Autowired
	private AccountDAOJDBCImpl accountJDBC;
	
	public Account getInformation(String email) {
		
		Account account = accountJDBC.getAccount(email);	
		return account;
		
	}

}
