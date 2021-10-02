package com.simplilearn.sportyshoes.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler {
	  @ExceptionHandler(value={RuntimeException.class})
	  public String exceptionhandler(){
		return "RuntimeException";
		  
}
	}
