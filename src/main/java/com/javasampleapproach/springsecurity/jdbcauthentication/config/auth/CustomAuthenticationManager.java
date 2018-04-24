package com.javasampleapproach.springsecurity.jdbcauthentication.config.auth;

import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impelemetations.RoleDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.DAO.impelemetations.UserDAOImp;
import com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices.RoleService;
import com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationManager implements AuthenticationManager{

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    Md5PasswordEncoder md5PasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("__________________________________________");


        String username = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        String role = roleService.getByUserName(username).getRole();
        String bDpass = userService.getByUserName(username).getPassword();

        GrantedAuthority authority = new SimpleGrantedAuthority(role);


        User user = new User(username,bDpass ,Arrays.asList(authority));


        System.out.println(user.getPassword());

        if (user == null) {
            throw new BadCredentialsException("1000");
        }
        if (user.isEnabled()) {
            throw new DisabledException("1001");
        }
        if (md5PasswordEncoder.isPasswordValid(password, user.getPassword(),null)) {
            throw new BadCredentialsException("1000");
        }

        return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList(authority));
    }

}
