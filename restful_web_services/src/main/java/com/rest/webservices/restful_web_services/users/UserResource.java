package com.rest.webservices.restful_web_services.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.hateoas.EntityModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;


/*this class can be named as controller as well*/

@RestController
public class UserResource {

@Autowired
private UserDaoService service;
	
@GetMapping("/users")	
	public List<User> retrieveAllUsers(){
	
	return service.findAll();
	
}

//commented for implementation of Hateoas
 
 @GetMapping("/users/{id}")
public User retrieveUser(@PathVariable int id) {
	 User user =service.findOne(id);
	 if(user==null ) { //created exception class for user for null exception
		 throw new UserNotFoundException("id-"+id);
	  }
	 
	
	 
	return user;
}


/*
@GetMapping("/users/{id}")
public EntityModel<User> retrieveUser(@PathVariable int id) {
	User user = service.findOne(id);
	
	if(user==null)
		throw new UserNotFoundException("id-"+ id);
	
	
	//"all-users", SERVER_PATH + "/users"
	//retrieveAllUsers
	EntityModel<User> resource = EntityModel.of(user);
	
	WebMvcLinkBuilder linkTo = 
			linkTo(methodOn(this.getClass()).retrieveAllUsers());
	
	resource.add(linkTo.withRel("all-users"));
	
	//HATEOAS
	
	return resource;
}






 
private WebMvcLinkBuilder linkTo(List<User> retrieveAllUsers) {
	// TODO Auto-generated method stub
	return null;
}

private UserResource methodOn(Class<? extends UserResource> class1) {
	// TODO Auto-generated method stub
	return null;
}*/

/*@RequestBody get details of request into the request body of User*/

 
 @PostMapping("/users")
public ResponseEntity<Object> creatUser(@Valid @RequestBody User user) {
    //return service.save(user);
    User savedUser=service.save(user);
    //CREATED
    //user/{id}
 URI location= ServletUriComponentsBuilder   /*this code is added to getUser know User has been created*/
    .fromCurrentRequest() //that is "/users"
    .path("{id}")  //map its id to /users/id
    .buildAndExpand(savedUser.getId()).toUri();  
    /*ResponseEntity is basically add on for HttpStatusCode */
    return ResponseEntity.created(location).build();   //it return URI of the created User
    
    
}
	

@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable int id) {
	 User user =service.deleteById(id);
	 if(user==null ) { //created exception class for user for null exception
		 throw new UserNotFoundException("id-"+id);
	 }
	
}




	
}
