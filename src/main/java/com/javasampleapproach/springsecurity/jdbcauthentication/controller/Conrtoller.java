package com.javasampleapproach.springsecurity.jdbcauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Conrtoller {

    @Autowired
    JdbcUserDetailsManager userDetailsManager;

    @RequestMapping(value = "123")
    public String createUser() {

        /*ArrayList<GrantedAuthority> grantedAuthorityArrayList = new ArrayList<>();

        grantedAuthorityArrayList.add(new SimpleGrantedAuthority("USER"));

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String password = bCryptPasswordEncoder.encode("123");

        User user = new User("123", password, Arrays.asList(new SimpleGrantedAuthority("USER")));

        userDetailsManager.createUser(user);
*/
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        return auth.getAuthorities().toString();
    }

    @RequestMapping(value = "13")
    public String testRole() {

        /*ArrayList<GrantedAuthority> grantedAuthorityArrayList = new ArrayList<>();

        grantedAuthorityArrayList.add(new SimpleGrantedAuthority("USER"));

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String password = bCryptPasswordEncoder.encode("123");

        User user = new User("123", password, Arrays.asList(new SimpleGrantedAuthority("USER")));

        userDetailsManager.createUser(user);
*/
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        return auth.getAuthorities().toString();
    }

}
