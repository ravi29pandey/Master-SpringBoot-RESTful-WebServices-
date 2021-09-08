package com.rest.webservices.restful_web_services.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAResource {

	
@Autowired
private UserRepository userRepository;
	

@Autowired
private PostRepository PostRepository;


@GetMapping("/jpa/users")	
	public List<User> retrieveAllUsers(){
	
	return userRepository.findAll();
	 
}

//commented for implementation of Hateoas
 
 @GetMapping("/jpa/users/{id}")
public Optional<User> retrieveUser(@PathVariable int id) {
	 Optional<User> user =userRepository.findById(id);
	 if(!user.isPresent())  //created exception class for user for null exception
		 throw new UserNotFoundException("id-"+id);
	 
	 
	
	 
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

 
 @PostMapping("/jpa/users")
public ResponseEntity<Object> creatUser(@Valid @RequestBody User user) {
    //return service.save(user);
    User savedUser=userRepository.save(user);
    //CREATED
    //user/{id}
 URI location= ServletUriComponentsBuilder   /*this code is added to let User know User has been created*/
    .fromCurrentRequest() //that is "/users"
    .path("{id}")  //map its id to /users/id
    .buildAndExpand(savedUser.getId()).toUri();  
    /*ResponseEntity is basically add on for HttpStatusCode */
    return ResponseEntity.created(location).build();   //it return URI of the created User
    
    
}
	

@DeleteMapping("/jpa/users/{id}")
public void deleteUser(@PathVariable int id) {
	userRepository.deleteById(id);
	
}


@GetMapping("/jpa/users/{id}/posts")	
public List<Post> retrieveAllUsers(@PathVariable int id){

	Optional<User> userOptional=userRepository.findById(id);
	if(!userOptional.isPresent()) {
		
		throw new UserNotFoundException("id-"+id);
	}
	
	return userOptional.get().getPost();
                  

}


@PostMapping("/jpa/users/{id}/posts")
public ResponseEntity<Object> creatPost(@PathVariable int id,@RequestBody Post post) {
	Optional<User> userOptional=userRepository.findById(id);
	if(!userOptional.isPresent()) {
		
		throw new UserNotFoundException("id-"+id);
	}
	User user=userOptional.get();
	
	post.setUser(user);

	
	
	PostRepository.save(post);
	
 URI location= ServletUriComponentsBuilder   /*this code is added to let User know User has been created*/
    .fromCurrentRequest() //that is "/users"
    .path("{id}")  //map its id to /users/id
    .buildAndExpand(post.getId()).toUri();  
    /*ResponseEntity is basically add on for HttpStatusCode */
    return ResponseEntity.created(location).build();   //it return URI of the created User
    
    
}



	
}
