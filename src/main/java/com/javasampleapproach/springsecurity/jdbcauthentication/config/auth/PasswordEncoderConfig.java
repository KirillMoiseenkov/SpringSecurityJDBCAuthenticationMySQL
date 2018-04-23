package com.javasampleapproach.springsecurity.jdbcauthentication.config.auth;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public Md5PasswordEncoder PasswordEncoder(){

        return new Md5PasswordEncoder();

    }



}
