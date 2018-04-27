package com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices;


import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impl.UserDAOImpl;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAOImpl userDAOImpl;

    public User getByUserName(String userName) {
        return userDAOImpl.getByUserName(userName);
    }


}
