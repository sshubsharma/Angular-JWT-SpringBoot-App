package com.project.shubham.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	//we can map with two mapping
	/*
	 * @GetMapping("v1/perosn") public PersonV1 personv1() { return new
	 * PersonV1("shubham sharma"); }
	 */
	//we can use param request-->through URI
	@GetMapping(value = "v1/param",params = "version=1")
	public PersonV1 personv1() {
		return new PersonV1("shubham sharma");
	}
	
	@GetMapping(value = "v1/param",params = "version=2")
	public PersonV2 personv2() {
		return new PersonV2(new Name("shubham", "sharma"));
	}
	
	//we can use Param Header
	
	@GetMapping(value = "v1/header",headers= "API_VERSION=1")
	public PersonV1 headerv1() {
		return new PersonV1("shubham sharma");
	}
	
	@GetMapping(value = "v1/header",headers =  "API_VERSION=2")
	public PersonV2 headerv2() {
		return new PersonV2(new Name("shubham", "sharma"));
	}
	
	
	//we can use Producer header-->Versioning through content negotiation
	
		@GetMapping(value = "v1/producer",produces= "application/sharma.company.app-v1+json")
		public PersonV1 producerv1() {
			return new PersonV1("shubham sharma");
		}
		
		@GetMapping(value = "v1/producer",headers =  "application/sharma.company.app-v2+json")
		public PersonV2 producerv2() {
			return new PersonV2(new Name("shubham", "sharma"));
		}
	
	

}
