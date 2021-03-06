package com.javasampleapproach.springsecurity.jdbcauthentication.config.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserDetailServiceConfig {

    private final String sqlRole = "select username, authority from authorities where username=?";
    private final String sqlUsers = "";

    @Autowired
    DataSource dataSource;


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(JdbcUserDetailsManager userDetailServiceImp) {


        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailServiceImp);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    @Scope("singleton")
    public JdbcUserDetailsManager userDetailService() {

        JdbcUserDetailsManager userDetailService = new JdbcUserDetailsManager();
        userDetailService.setDataSource(dataSource);
        userDetailService.setAuthoritiesByUsernameQuery(sqlRole);
        return userDetailService;

    }


}
