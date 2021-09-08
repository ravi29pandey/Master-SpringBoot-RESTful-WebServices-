package com.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	/*Enter full name V1 service | for first name & last name v2 service*/

	//this is URI Versioning (Used by Twitter)
	
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		
		return new PersonV1("Ravi Pandey");
		
	}
	@GetMapping("/v2/person")
      public PersonV2 personV2() {
		
		return new PersonV2(new Name("Ravi","Pandey"));
		
	}
	
	//other ways of doing it --- using Request param versioning(used by Amazon) search http://localhost:8080/person/param?version=2
	
	@GetMapping(value ="/person/param",params="version=1")
	public PersonV1 paramV11() {
		
		return new PersonV1("Ravi Pandey");
		
	}
	@GetMapping(value="/person/param",params="version=2")
    public PersonV2 paramV21() {
		
		return new PersonV2(new Name("Ravi","Pandey"));
		
	}
	
	
	
	//other ways of doing it --- using Header Versioning used by Microsoft  
	
		@GetMapping(value ="/person/header",params="X-API_VERSION=1")
		public PersonV1 headerV1() {
			
			return new PersonV1("Ravi Pandey");
			
		}
		@GetMapping(value="/person/header",params="X-API_VERSION=2")
	    public PersonV2 headerV2() {
			
			return new PersonV2(new Name("Ravi","Pandey"));
			
		}
		
	
		
/*		Factors
		*URI pollution too many URI 
		*Misuse of Http Header - Header Versioning
		*Caching
		*Can we execute request to brpwser - no for Header 
		*API documentation - easy for param and URI versioning
		*No perfect solution there
		*/
		
		
		
		
		
}
