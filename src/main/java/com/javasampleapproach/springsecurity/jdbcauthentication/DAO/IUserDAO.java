package com.javasampleapproach.springsecurity.jdbcauthentication.DAO;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.User;

public interface IUserDAO {

    public User getByUserName(String userName);

}
