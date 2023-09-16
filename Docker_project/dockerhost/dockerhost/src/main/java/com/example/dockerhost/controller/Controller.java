package com.example.dockerhost.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/getMsg")
	public String getMessage() {
		return "Hey deployment done...";
	}

}
