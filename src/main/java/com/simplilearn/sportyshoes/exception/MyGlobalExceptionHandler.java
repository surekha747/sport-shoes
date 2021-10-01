package com.simplilearn.sportyshoes.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler {
	  @ExceptionHandler(value={RuntimeException.class})
	  public String exceptionhandler(){
		return "RuntimeException";
		  
}
	}
