package com.javasampleapproach.springsecurity.jdbcauthentication.config.auth;


import com.javasampleapproach.springsecurity.jdbcauthentication.service.authService.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;

import javax.sql.DataSource;

@Configuration
public class UserDetailServiceConf {

    @Autowired
    DataSource dataSource;

    @Bean
    public UserDetailServiceImp userDetailServiceImp()
    {
        UserDetailServiceImp userDetailServiceImp = new UserDetailServiceImp();
        userDetailServiceImp.setDataSource(dataSource);
        return userDetailServiceImp;

    }



}
