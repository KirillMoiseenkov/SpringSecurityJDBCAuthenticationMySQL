package com.javasampleapproach.springsecurity.jdbcauthentication.service.authService;

import com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices.RoleService;
import com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailServiceImp implements UserDetailsService{

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user;

        String password = userService.getByUserName(userName).getPassword();
        String role = roleService.getByUserName(userName).getRole();

        GrantedAuthority authority = new SimpleGrantedAuthority(role);

        user = new User(userName,password, Arrays.asList(authority));

        return user;
    }
}
