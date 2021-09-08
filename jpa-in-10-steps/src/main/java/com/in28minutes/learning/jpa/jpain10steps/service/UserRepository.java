package com.in28minutes.learning.jpa.jpain10steps.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

/*this code basically create a Repository for User and long is for the id that is the primary key*/
public interface UserRepository extends JpaRepository<User,Long>{

}


