package com.rest.webservices.restful_web_services.Exception;

import java.util.Date;

public class ExceptionResponse {
   
private Date timestamp;
private String message;
private String details;



public ExceptionResponse(Date timestamp, String message, String details) {
	super();
	this.timestamp = timestamp; /*/time at which error arise */
	this.message = message;
	this.details = details;
}
public Date getTimestamp() {
	return timestamp;
}
public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}





}
