package com.project.shubham.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.shubham.Service.ApplicationService;
import com.project.shubham.exception.UserNotFoundException;
import com.project.shubham.model.ApplicationDTO;

@RestController
public class ApplicationController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ApplicationService service;
	
	@GetMapping(path="/helloworld")
	public String hellowWorld() {
		return "hello";
	}
	
	@GetMapping(path="/hello-World")
	public HelloBean getData() {
		return new HelloBean("hellow Bean");
	}
	
	//path variable
	@GetMapping(path="/helloBean/path-varibale/{name}")
	public HelloBean getPathVariable(@PathVariable String name) {
		return new HelloBean(String.format("Hello, %s",name));
	}
	
	//getallusers
	@GetMapping(path="/users")
	public List<ApplicationDTO> getAllusers(){
		return service.finaAll();
	}
	
	//get specific user
	@GetMapping(path="/users/{id}")
	public ApplicationDTO getuser(@PathVariable int id) {
		ApplicationDTO applicationDTO=service.findOne(id);
		if(applicationDTO==null) {
			throw new UserNotFoundException("id-" + id);
		}
		//use of hateoas Hypermedia As The Engine Of Application State
		
		//Resource<ApplicationDTO> resource=new Resource<ApplicationDTO>(applicationDTO);
		//ControllerLinkBuilder linkto=ControllerLinkBuilder<ApplicationDTO>.linkTo(methodOn(this.getClass()).getAllusers()));
		//resource.add(linkto.withRel("all-users"));
		 return applicationDTO;
		
	}

	//save the user
	@PostMapping(path="/users")
	public ResponseEntity<Object> save(@Validated @RequestBody ApplicationDTO applicationDTO) {
		ApplicationDTO appDTO=service.save(applicationDTO);
		
		//to return the status for current request
		URI location=ServletUriComponentsBuilder.
		fromCurrentRequest().path("{/id}").
		buildAndExpand(appDTO.getId()).toUri();
		//return the status code back
		return ResponseEntity.created(location).build();
	}
	
	//delete userbyid
	
	//get specific user
		@DeleteMapping(path="/users/{id}")
		public void deleteById(@PathVariable int id) {
			ApplicationDTO applicationDTO=service.deleteByid(id);
			if(applicationDTO==null) {
				throw new UserNotFoundException("id-" + id);
				
			}
			
		}
		
		//i18n
		@GetMapping(path="/hello-World-I18N")
		//public String HelloI18N(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		//to simplyfy the method its  very painfull to provide @RequestHeader for every method
				//so there is ann alternative for this below	
		public String HelloI18N() {
			return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
		}
}
