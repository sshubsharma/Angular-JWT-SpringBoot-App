package com.shubham.rest.webservices.controller;

public class HellowWorldBean {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HellowWorldBean(String message) {
		this.message=message;
	}

	@Override
	public String toString() {
		return "HellowWorldBean [message=" + message + "]";
	}

}
