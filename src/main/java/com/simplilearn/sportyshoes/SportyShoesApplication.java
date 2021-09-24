package com.simplilearn.sportyshoes;



import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author surekha
 *
 */
@SpringBootApplication

public class SportyShoesApplication {
 
	
	/*
	 * @Bean public WebSecurityConfigurerAdapter webSecurityConfig(DataSource
	 * dataSource) { return new WebSecurityConfigurerAdapter() {
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.authorizeRequests().antMatchers("/").permitAll().and()
	 * .authorizeRequests().antMatchers("/console/**").permitAll();
	 * http.csrf().disable(); http.headers().frameOptions().disable(); }
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder builder)
	 * throws Exception { builder.jdbcAuthentication() .dataSource(dataSource); } };
	 * }
	 */

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
	}

}
