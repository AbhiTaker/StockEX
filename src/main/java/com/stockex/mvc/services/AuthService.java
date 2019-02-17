package com.stockex.mvc.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockex.mvc.dao.UserDAOJDBCImpl;
import com.stockex.mvc.entities.User;

@Service
public class AuthService {
	
	@Autowired
	private UserDAOJDBCImpl userJDBC;
	
	public boolean authenticate(User user) {
		
		List<User> users = userJDBC.listUsers();
		for(User val: users) {
			if(Objects.equals(user.getEmail(), val.getEmail()) && Objects.equals(user.getPassword(), val.getPassword())
					&& Objects.equals(user.getUsertype(), val.getUsertype())) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean registerUser(User user) {
		
		List<User> users = userJDBC.listUsers();
		for(User val: users) {
			if(Objects.equals(user.getEmail(), val.getEmail()))
				return false;
		}
		userJDBC.createUser(user);
		return true;
	}
	

}