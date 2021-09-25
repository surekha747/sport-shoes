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
	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
	}

}
