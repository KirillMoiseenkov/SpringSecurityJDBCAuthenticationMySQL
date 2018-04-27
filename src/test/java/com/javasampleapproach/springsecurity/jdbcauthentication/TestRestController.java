package com.javasampleapproach.springsecurity.jdbcauthentication;


import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impl.RoleDAOImpl;
import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impl.UserDAOImpl;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
import com.javasampleapproach.springsecurity.jdbcauthentication.service.authService.UserDetailServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RunWith(SpringRunner.class)
public class TestRestController {

    Some some = new Some();


    @Autowired
    DataSource dataSource;

    @Autowired
    UserDAOImpl userDAOImpl;

    @Autowired
    RoleDAOImpl roleDAOImpl;

    @Autowired
    UserDetailServiceImp userDetailServiceImp;

    @Test
    @RequestMapping(value = "/jdbcTest", method = RequestMethod.GET)
    public void getUser(String username) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        //  jdbcTemplate.update("update users set password = ? where username = ?", "ababab","kirill");


        // System.out.println(userDetailServiceImp.loadUserByUsername("kirill").getPassword());
/*
        DatabasePasswordSecurerBean databasePasswordSecurerBean= new DatabasePasswordSecurerBean();

        databasePasswordSecurerBean.secureDatabase();
*/
    }

    @Test
    @RequestMapping(value = "/another", method = RequestMethod.GET)
    public Some getString() {

        some.setId(1);
        some.setName("Name");
        return some;

    }

    @Test
    @RequestMapping(value = "/nonAuth", method = RequestMethod.GET)
    public Some nonAuth() {


        some.setId(1);
        some.setName("Name");
        return some;

    }


}
