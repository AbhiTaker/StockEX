package com.stockex.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	public boolean authenticate(User user) {
		
		User val = userJDBC.getUser(user.getEmail());
		if(val == null)
			return false;
			System.out.println(val.getEmail());
			System.out.println(val.getPassword());
			System.out.println(val.getFirstName());
			System.out.println(val.getLastName());
			System.out.println(val.getUsertype());
		
		return true;
	}

}
