package com.javasampleapproach.springsecurity.jdbcauthentication.controller;


import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impelemetations.RoleDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impelemetations.UserDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
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

    @RequestMapping(value = "/jdbcTest", method = RequestMethod.GET)
    public void getUser(String username) throws SQLException {

       /* JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select username,password, enabled from users where username=?";

        List<String> s;
        s = jdbcTemplate.query(sql,new Object[]{"kirill"},new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("password");
            }
        });


        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();

      String encodePassword = md5PasswordEncoder.encodePassword(s.get(0),null);


        System.out.println(encodePassword + "first");*/

        System.out.println(userDAOImp.getByUserName("kirill").toString());
        System.out.println(roleDAOImp.getByUserName("kirill").toString());
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
