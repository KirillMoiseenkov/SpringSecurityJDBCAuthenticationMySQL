package com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices;


import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.UserDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAOImp userDAOImp;

    public User getByUserName(String userName) {
        return userDAOImp.getByUserName(userName);
    }


}
