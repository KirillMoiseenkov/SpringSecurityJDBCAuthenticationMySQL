package com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices;

import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impl.RoleDAOImpl;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDAOImpl roleDAOImpl;

    public Role getByUserName(String userName) {
        return roleDAOImpl.getByUserName(userName);

    }

}
