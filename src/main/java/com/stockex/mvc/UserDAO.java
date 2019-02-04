package com.stockex.mvc;

import java.util.List;
import javax.sql.DataSource;

public interface UserDAO {
  
  // set database connection
  public void setDataSource(DataSource ds);
  
  // create a new user record in the users table
  public void create(String name, String email);
  
  // get a user with the passed email
  public User getUser(String email);
  
  // get all the users from the users table
  public List<User> listUsers();
  
  // update a user's password given the user's Email
  public void updatePassword(String email, String password);
  
  // delete a user record from the users table given the user's Email
  public void delete(String email);
}
