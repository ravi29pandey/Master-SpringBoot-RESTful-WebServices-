package com.rest.webservices.restful_web_services.users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="All details about the user")
@Entity
public class User {

	@Id
	@GeneratedValue   /*telling JPA to generate value in database (auto)*/
	private Integer id;
	
	@Size(min=2,message= "Name should not be less than 2 Char,")
	@ApiModelProperty(notes="Name should not be less than 2 Char")
	private String name;
	
	@Past
	@ApiModelProperty(notes="BirthDate has to be in the past")
	private Date birthDate;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	@OneToMany(mappedBy="user")
	private List<Post> post;
	
	
	
	

	protected User() {}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; 
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
	
}
