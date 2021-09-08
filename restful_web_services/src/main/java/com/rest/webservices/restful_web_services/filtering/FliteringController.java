package com.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FliteringController {
   
/*	@Autowired
	private SomeBean somebean;
	
	*/
	@GetMapping("/filtering")  // Dynamic Filtering
	 public MappingJacksonValue retrieveSomeBean() {
		
		SomeBean someBean=new SomeBean("Value1","Value2","Value3");
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters =new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		
		
		return mapping;
	 }
	
	
	/*Dynamic filtering of list*/
	
	@GetMapping("/filtering-list")
	 public MappingJacksonValue retrieveListofSomeBean() {
		
	List<SomeBean> list =	Arrays.asList(new SomeBean("Value1222", "Value3222", "Value2222"));
		
		
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters =new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
		 
	 }
	
	
}
