package com.rest.webservices.restful_web_services.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.restful_web_services.users.UserNotFoundException;


@ControllerAdvice /*Multiple controller class share same exception handling throughout project*/
@RestController
public class CustomizedResponseEntityExceptionHandler 
extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException
	(Exception ex, WebRequest request){
		
	ExceptionResponse exceptionresponse=	new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	  
	
	return new ResponseEntity(exceptionresponse,HttpStatus.INTERNAL_SERVER_ERROR);
		

		
		
	}
	
	/*specific exception*/
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserException
	(UserNotFoundException ex, WebRequest request){
		
	ExceptionResponse exceptionresponse=	new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	  
	
	return new ResponseEntity(exceptionresponse,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
			
		ExceptionResponse exceptionresponse=	new ExceptionResponse(new Date(), "Validation failed",
				ex.getBindingResult().toString());
			  
			
			return new ResponseEntity(exceptionresponse,HttpStatus.BAD_REQUEST);
				
	}



	
	
	
}
