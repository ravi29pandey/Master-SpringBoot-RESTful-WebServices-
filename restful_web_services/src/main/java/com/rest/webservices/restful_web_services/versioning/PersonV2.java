package com.rest.webservices.restful_web_services.versioning;

public class PersonV2 {

	private Name name;

	public PersonV2() {
		super();
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
}
