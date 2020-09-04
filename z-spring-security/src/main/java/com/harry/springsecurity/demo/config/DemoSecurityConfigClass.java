package com.harry.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfigClass extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	@SuppressWarnings("deprecation")
	UserBuilder userBuilder = User.withDefaultPasswordEncoder();

	auth.inMemoryAuthentication().withUser(userBuilder.username("john").password("test123").roles("EMPLOYEE"))
		.withUser(userBuilder.username("ram").password("test123").roles("MANAGER"))
		.withUser(userBuilder.username("shyam").password("test123").roles("ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

	http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("cutomLogin")
		.loginProcessingUrl("autheticateUser").permitAll();

    }

}
