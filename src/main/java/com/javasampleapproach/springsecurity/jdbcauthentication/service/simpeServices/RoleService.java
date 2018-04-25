package com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices;

import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.RoleDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDAOImp roleDAOImp;

    public Role getByUserName(String userName) {
        return roleDAOImp.getByUserName(userName);

    }

}
