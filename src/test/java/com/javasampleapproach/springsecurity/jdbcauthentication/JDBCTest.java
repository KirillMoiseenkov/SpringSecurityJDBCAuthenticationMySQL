package com.javasampleapproach.springsecurity.jdbcauthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCTest {

    @Autowired
    DataSource dataSource;

    public void getUser(String username) throws SQLException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select username from users where username=:?";

       List<String> s;
        s = jdbcTemplate.query(sql,new Object[]{username},new RowMapper<String>() {
             public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                 return rs.getString("username");
             }
         });

        s.forEach(i-> System.out.println(i));

    }


}
