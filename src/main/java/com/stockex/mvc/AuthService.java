package com.stockex.mvc;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
	
	public boolean authenticate(User user) {
		if(user.usertype.equals("admin") && 
				user.mail.equals("abhi.taker20@gmail.com") && user.password.equals("qwerty")) {
			return true;
		}
		return false;
	}

}
