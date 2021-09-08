package com.rest.webservices.restful_web_services.versioning;

public class PersonV1 {
	private String Name;

	@Override
	public String toString() {
		return "PersonV1 [Name=" + Name + "]";
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public PersonV1(String name) {
		super();
		Name = name;
	}
	
}
