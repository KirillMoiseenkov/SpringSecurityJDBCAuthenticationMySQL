package com.javasampleapproach.springsecurity.jdbcauthentication.controller;


import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.RoleDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.UserDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
import com.javasampleapproach.springsecurity.jdbcauthentication.service.authService.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        //  jdbcTemplate.update("update users set password = ? where username = ?", "ababab","kirill");


        // System.out.println(userDetailServiceImp.loadUserByUsername("kirill").getPassword());
/*
        DatabasePasswordSecurerBean databasePasswordSecurerBean= new DatabasePasswordSecurerBean();

        databasePasswordSecurerBean.secureDatabase();
*/
    }

    @RequestMapping(value = "/another", method = RequestMethod.GET)
    public Some getString() {

        some.setId(1);
        some.setName("Name");
        return some;

    }

    @RequestMapping(value = "/nonAuth", method = RequestMethod.GET)
    public Some nonAuth() {


        some.setId(1);
        some.setName("Name");
        return some;

    }


}
