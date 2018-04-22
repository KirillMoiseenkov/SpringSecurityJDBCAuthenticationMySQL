package com.javasampleapproach.springsecurity.jdbcauthentication.controller;


import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impelemetations.RoleDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impelemetations.UserDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
import com.javasampleapproach.springsecurity.jdbcauthentication.service.authService.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
@CrossOrigin
public class TestRestController {

    Some some = new Some();


    @Autowired
    DataSource dataSource;

    @Autowired
    UserDAOImp userDAOImp;

    @Autowired
    RoleDAOImp roleDAOImp;

    @Autowired
    UserDetailServiceImp userDetailServiceImp;

    @RequestMapping(value = "/jdbcTest", method = RequestMethod.GET)
    public void getUser(String username) throws SQLException {

//        System.out.println(userDetailServiceImp.userExists("kirill"));


    }

    @RequestMapping(value = "/another", method = RequestMethod.GET)
    public Some getString(){

        some.setId(1);
        some.setName("Name");
        return some;

    }

    @RequestMapping(value = "/nonAuth", method = RequestMethod.GET)
    public Some nonAuth(){



        some.setId(1);
        some.setName("Name");
        return some;

    }



}
