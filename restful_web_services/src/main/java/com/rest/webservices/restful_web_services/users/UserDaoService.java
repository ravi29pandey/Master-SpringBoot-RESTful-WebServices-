package com.rest.webservices.restful_web_services.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.stereotype.Component;



@Component
public class UserDaoService {

	private static ArrayList<User> users=new ArrayList<>();
 
	private static int usercount=3;
	
	static {
		users.add(new User(1,"Ravi",new Date()));
		users.add(new User(2,"Saurabh",new Date()));
		users.add(new User(3,"Coder",new Date()));
		users.add(new User(5,"Hello",new Date()));
		 
	}
	//getAllUser
  public ArrayList<User> findAll(){
		
		return users;
	}
  //Save a user
    public User save(User user){
		if(user.getId() == null) {
    		user.setId(++usercount);
    	}
    	
	users.add(user);
	return user;
	}
    
    //find one user
    
    public User findOne(int id){
		for(User user:users) {
    	if(user.getId()==id) {
    	       return user;
    	  }
		}
		return null;
    	
    
    }
    
    
    public User findOneByName(String name){
		for(User user:users) {
    	if(user.getName()==name) {
    	       return user;
    	  }
		}
		return null;
    	
    }
    
    
    public User deleteById(int id){
    	
    Iterator<User> iterator=users.iterator();    	
		while(iterator.hasNext()) {
			
			User user=iterator.next();
			
    	if(user.getId()==id) {
    		iterator.remove();
    	       return user;
    	  }
		}
		return null;
    	
    
    }
    
	
}
