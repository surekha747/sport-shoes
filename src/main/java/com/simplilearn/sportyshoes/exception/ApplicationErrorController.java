package com.simplilearn.sportyshoes.exception;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Component;

@Component
public class ApplicationErrorController implements ErrorController {

	public String getErrorPath() {
		
		return "Hey user, Site is under maintenance, please try after some time";
	}

}