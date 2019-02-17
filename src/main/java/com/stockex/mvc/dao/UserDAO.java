package com.stockex.mvc.dao;

import java.util.List;
import javax.sql.DataSource;

import com.stockex.mvc.entities.User;

public interface UserDAO {
  
  // set database connection
  public void setDataSource(DataSource ds);
  
  // create a new user record in the users table
  public void createUser(User user);
  
  // get a user with the passed email
  public User getUser(String email);
  
  public String getUsername(String email);
  
  // get all the users from the users table
  public List<User> listUsers();
  
  // update a user's information given the users
  public void updateUser(User user);
  
  // delete a user record from the users table given the user's Email
  public void delete(String email);
  
}
