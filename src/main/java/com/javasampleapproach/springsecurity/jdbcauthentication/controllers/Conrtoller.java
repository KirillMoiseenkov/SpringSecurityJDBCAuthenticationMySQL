package com.javasampleapproach.springsecurity.jdbcauthentication.controllers;

import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.AdditionalPriceService;
import com.javasampleapproach.springsecurity.jdbcauthentication.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@SessionAttributes("some")
public class Conrtoller {

    private static final Logger log = Logger.getLogger(Conrtoller.class);

    @Autowired
    ProductService productService;

    @Autowired
    AdditionalPriceService additionalPriceService;

    @ModelAttribute("some")
    public Some populatePerson() {

        Some some = new Some();
        some.setName("Kirill");
        some.setId(1);
        return some;
    }


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
    public String testRole(@ModelAttribute Some some) {

        return additionalPriceService.getAll().toString();

    }

}
