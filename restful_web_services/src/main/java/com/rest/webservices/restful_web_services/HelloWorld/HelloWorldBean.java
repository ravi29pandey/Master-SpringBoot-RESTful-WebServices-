package com.rest.webservices.restful_web_services.HelloWorld;

public class HelloWorldBean {

	
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}


	public HelloWorldBean(String message) {
	this.message= message;
	
	}

	
	
	
}