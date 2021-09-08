package com.rest.webservices.restful_web_services.HelloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldCntroller {

	@Autowired
	private MessageSource messageSource;
	
	
@GetMapping(path="/hello-world")
public String HelloWorld() {
	return "Hello World";
}

@GetMapping(path="/hello-world-bean")
public HelloWorldBean HelloWorldBean() {
	return new HelloWorldBean("Hello World");
 }


@GetMapping(path="/hello-world/path-variable/{name}")
public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
	return new HelloWorldBean(String.format("Hello , %s" ,name));
 }

 

@GetMapping(path="/hello-world-internationlized")
public String HelloWorldInternational() {
return messageSource.getMessage("good.morning.messages", null,LocaleContextHolder.getLocale());
}
}