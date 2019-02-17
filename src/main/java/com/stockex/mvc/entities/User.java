package com.stockex.mvc.entities;


public class User {
	
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	private String usertype;
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setFirstName(String first_name) {
	    this.first_name = first_name;
	 }
	  
	public String getFirstName() {
	    return first_name;
	 }
	  
	public void setLastName(String last_name) {
	    this.last_name = last_name;
	 }
	  
	public String getLastName() {
	    return last_name;
	 }
	
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	public String getUsertype() {
		return usertype;
	}
	  
}
