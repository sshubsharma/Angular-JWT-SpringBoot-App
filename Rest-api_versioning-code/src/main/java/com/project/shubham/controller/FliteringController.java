package com.project.shubham.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

//using for static filtering in restAPI
@RestController
//ignore the values in response for static filtering
@JsonIgnoreProperties(value = {"f2"})
public class FliteringController {
	
	
	@GetMapping("/fltering")
	//public SomeBean getFields() {
	//for dynamic filtering
	public MappingJacksonValue getFields() {
		SomeBean someBean= new SomeBean("f1","f2","f3");
		//static filtering
		SimpleBeanPropertyFilter simpleBeanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("f1");
		FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SimpleBeanFilter", simpleBeanPropertyFilter);
		MappingJacksonValue MappingJacksonValue=new MappingJacksonValue(someBean);
		MappingJacksonValue.setFilters(filterProvider);
		
		return MappingJacksonValue;
	}
	
	@GetMapping("/fltering-list")
	public List<SomeBean> getFieldsList() {
		return Arrays.asList(new SomeBean("f1","f2","f3"),new SomeBean("value1", "value2", "value3"));
	}

}
