package com.javasampleapproach.springsecurity.jdbcauthentication.config.auth;


import com.javasampleapproach.springsecurity.jdbcauthentication.service.authService.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class UserDetailServiceConfig {

    private final String sqlRole = "select username, role from user_roles where username=?";

    @Autowired
    DataSource dataSource;

    @Autowired
    CustomAuthenticationManager authenticationManager;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailServiceImp userDetailServiceImp) {


        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailServiceImp);
        daoAuthenticationProvider.setPasswordEncoder(new Md5PasswordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public UserDetailServiceImp userDetailServiceImp() {

        UserDetailServiceImp userDetailServiceImp = new UserDetailServiceImp();
        userDetailServiceImp.setDataSource(dataSource);
        userDetailServiceImp.setAuthoritiesByUsernameQuery(sqlRole);
        userDetailServiceImp.setAuthenticationManager(authenticationManager);

        return userDetailServiceImp;

    }


}
