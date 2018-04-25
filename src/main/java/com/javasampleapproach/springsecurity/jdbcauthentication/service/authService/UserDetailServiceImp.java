package com.javasampleapproach.springsecurity.jdbcauthentication.service.authService;

import com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices.RoleService;
import com.javasampleapproach.springsecurity.jdbcauthentication.service.simpeServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp extends JdbcUserDetailsManager {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    Md5PasswordEncoder md5PasswordEncoder;



    /*@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        String password = md5PasswordEncoder.encodePassword(userService.getByUserName(userName).getPassword(),null);

        String role = roleService.getByUserName(userName).getRole();

        GrantedAuthority authority = new SimpleGrantedAuthority(role);

        User user = new User(userName,password, Arrays.asList(authority));



        return user;
    }*/
}
