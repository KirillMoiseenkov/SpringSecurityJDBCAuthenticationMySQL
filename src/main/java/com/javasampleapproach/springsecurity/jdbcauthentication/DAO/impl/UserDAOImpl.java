package com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impl;

import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.IUserDAO;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public User getByUserName(String userName) {

        User user = new User();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select username, password from users where username=?";

        List<User> users = jdbcTemplate.query(sql, new Object[]{userName}, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                user.setUserName(userName);
                user.setPassword(rs.getString("password"));
                return user;
            }
        });

        return user;
    }
}