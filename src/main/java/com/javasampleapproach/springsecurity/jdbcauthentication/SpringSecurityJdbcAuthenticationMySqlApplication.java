package com.javasampleapproach.springsecurity.jdbcauthentication;

import com.javasampleapproach.springsecurity.jdbcauthentication.config.auth.UserDetailServiceConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityJdbcAuthenticationMySqlApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcAuthenticationMySqlApplication.class, args);


	}
}
