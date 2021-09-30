package com.simplilearn.sportyshoes;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;

import com.simplilearn.sportyshoes.config.SessionListener;




/**
 * @author surekha
 *
 */
@SpringBootApplication

public class SportyShoesApplication implements WebApplicationInitializer {
	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(new SessionListener());
		
	}

}
