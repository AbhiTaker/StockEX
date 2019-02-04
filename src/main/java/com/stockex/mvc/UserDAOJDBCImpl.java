package com.stockex.mvc;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOJDBCImpl implements UserDAO {

  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;
  
  public void setDataSource(DataSource ds) {
    dataSource = ds;
    jdbcTemplate = new JdbcTemplate(dataSource);
  }
  
  public void create(String name, String email) {
    String sql = "insert into users (name, email) values (?, ?)";
    jdbcTemplate.update(sql, name, email);
    System.out.println("Created User Name = " + name + " Email = " + email);
  }
  
  public User getUser(String email) {
    String sql = "select * from users where email = ?";
    User user = jdbcTemplate.queryForObject(sql, new Object[]{email}, new UserMapper());
    return user;
  }
  
  public List<User> listUsers() {
    String sql = "select * from users";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users;
  }
  
  public void updatePassword(String email, String password){
    String sql = "update users set password = ? where email= ?";
    jdbcTemplate.update(sql, password, email);
    System.out.println("Updated Record with Email = " +  email);
  }
  
  public void delete(String email){
    String sql = "delete from users where email = ?";
    jdbcTemplate.update(sql, email);
    System.out.println("Deleted Record with Email = " + email );
  }


}
