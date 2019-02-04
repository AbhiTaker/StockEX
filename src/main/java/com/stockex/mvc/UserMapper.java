package com.stockex.mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet  rs, int rowNum) throws SQLException {
    User user = new User();
    user.setEmail(rs.getString("email"));
    user.setPassword(rs.getString("password"));
    user.setFirstName(rs.getString("first_name"));
    user.setLastName(rs.getString("last_name"));
    user.setUsertype(rs.getString("usertype"));
    return user;
  }
}
