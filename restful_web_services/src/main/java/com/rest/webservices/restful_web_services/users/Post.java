package com.rest.webservices.restful_web_services.users;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
    private Integer id;
    private String  description;
	
    @ManyToOne(fetch=FetchType.LAZY)      /*User has many to one relation with Post
                                                          Fetch.LAZY so User itself doesn't load until post is called */
   @JsonIgnore   /*this will ignore User details in Post so to avoid recursion*/
    private User user;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override                                  /*Make sure not to select user here
	                                           as user kept on creating over n over again      */
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
	
	
	
	 }
