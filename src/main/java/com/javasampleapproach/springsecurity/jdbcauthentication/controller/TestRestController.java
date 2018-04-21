package com.javasampleapproach.springsecurity.jdbcauthentication.controller;


import com.javasampleapproach.springsecurity.jdbcauthentication.models.Some;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestRestController {

    Some some = new Some();


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
