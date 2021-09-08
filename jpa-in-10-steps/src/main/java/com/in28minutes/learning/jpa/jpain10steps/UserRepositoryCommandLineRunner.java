package com.in28minutes.learning.jpa.jpain10steps;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserDAOService;
import com.in28minutes.learning.jpa.jpain10steps.service.UserRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	
	
	private static final Logger log=
			  LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
		User user=new User("Ravi","Admin");
	     userRepository.save(user);
	     
	     java.util.Optional<User> userWithIdOne=userRepository.findById(1L);
		log.info("New User is Created using UserRepositoryService"+user + "User with id one" +"\n"+ userWithIdOne);
		
		
		
		List<User> users =userRepository.findAll();
		log.info("All Users: "+users);
		
		
		
		
	}

}

