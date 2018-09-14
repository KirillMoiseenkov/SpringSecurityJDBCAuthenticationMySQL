package com.javasampleapproach.springsecurity.jdbcauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class Conrtoller {

    @Autowired
    JdbcUserDetailsManager userDetailsManager;

    @RequestMapping(value = "123")
    public String createUser() {

        ArrayList<GrantedAuthority> grantedAuthorityArrayList = new ArrayList<>();

        grantedAuthorityArrayList.add(new SimpleGrantedAuthority("USER"));

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String password = bCryptPasswordEncoder.encode("123");

        User user = new User("123", password, Arrays.asList(new SimpleGrantedAuthority("USER")));

        userDetailsManager.createUser(user);

        return "123";
    }

}
