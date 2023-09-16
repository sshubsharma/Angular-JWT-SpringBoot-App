package com.shubham.rest.webservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HellowWorldController {
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hellow-World";
	}
	
	@GetMapping(path="/hello-worldBean")
	public HellowWorldBean helloWorldBean() {
		return new HellowWorldBean("hello-world-bean");
	}
	
	@GetMapping(path="/hello-worldBean/{name}")
	public HellowWorldBean helloWorldBean(@PathVariable String name) {
		return new HellowWorldBean("hello-world-bean" + name ) ;
	}

	

}
