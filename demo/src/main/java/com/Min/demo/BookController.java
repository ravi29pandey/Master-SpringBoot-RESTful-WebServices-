package com.Min.demo;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BookController {
	
	@GetMapping("/books")
	public java.util.List<Book> getAllBooks(){
		
		return Arrays.asList(
				new Book(1l,"Master SprinBoot","Ravi")
				,
				new Book(2l,"Master SprinBoot with RESTApi & Microservices","Ravi Pandey")
				);
				
		
	}
}
