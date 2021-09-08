package com.in28minutes.learning.jpa.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;


@Repository
public class UserDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public long insert(User user) {
		 
		/*persist method to make it mapped to entityManager*/
		entityManager.persist(user);
		
		
		return user.getId();
	}
	
//	@Repository
	//public class SomeEntityDAOService {

	//	@PersistenceContext  /*tells the service to track with only selective method*/
		//private EntityManager entityManager;
		
		//@Transactional
		//public long insert(SomeEntity entity) {
			 
			/*persist method to make it mapped to entityManager*/
			//entityManager.persist(entity);
			
			
	//		return user.getId();
		//}
		


	
}
