package com.springProject.securityConfigurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity	
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .antMatchers("/public/**").permitAll() // Allow public access to specific URLs
	            .anyRequest().authenticated() // Require authentication for any other URL
	        .and()
	        .formLogin() // Enable form-based authentication
	            .loginPage("/login") // Specify the login page URL
	            .permitAll() // Allow public access to the login page
	        .and()
	        .logout() // Enable logout support
	            .permitAll(); // Allow public access to the logout URL
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	        .inMemoryAuthentication()
	            .withUser("user")
	            .password("{noop}password")
	            .roles("USER");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	        .ignoring()
	            .antMatchers("/api/**"); // Exclude certain URLs from security filtering
	}	


}
