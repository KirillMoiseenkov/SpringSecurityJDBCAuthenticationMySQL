package com.javasampleapproach.springsecurity.jdbcauthentication.config.auth;

import javax.sql.DataSource;

import com.javasampleapproach.springsecurity.jdbcauthentication.service.authService.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static String REALM="MY_TEST_REALM";

	@Autowired
    UserDetailServiceImp userDetailServiceImp;

	@Autowired
	DataSource dataSource;
 
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailServiceImp).passwordEncoder(passwordEncoder());



	}

	public UserDetailServiceImp userDetailServiceImp(){
	    userDetailServiceImp.setDataSource(dataSource);
	    return userDetailServiceImp;
	}

	public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
					.authorizeRequests()
				.antMatchers("/another").hasRole("ADMIN")
				.antMatchers("/user/**").hasRole("ADMIN")
					.and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());
		}

		@Bean
		public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){

		return new CustomBasicAuthenticationEntryPoint();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("/another")
						.allowedHeaders("*");

			}

		};
	}*/



}