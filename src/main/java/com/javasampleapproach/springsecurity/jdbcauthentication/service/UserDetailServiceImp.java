package com.javasampleapproach.springsecurity.jdbcauthentication.service;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserDetailServiceImp{

    @Autowired
    DataSource dataSource;

   public String getUser(String name){

       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select username from users where username=:username";
       MapSqlParameterSource parameterSource = new MapSqlParameterSource();
       parameterSource.addValue("username", "kirill");
        jdbcTemplate.query(sql, new Object[] {"kirill"}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return "12";
            }
        });
   }
}
