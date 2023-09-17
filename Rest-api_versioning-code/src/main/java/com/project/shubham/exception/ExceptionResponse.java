package com.project.shubham.exception;

import java.util.Date;

public class ExceptionResponse {
	
	//basic element to create Exveptionrespose
	
	//timestamp
	//message
	//details
	
	private Date timestamp;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	private String message;
	public String getMessage() {
		return message;
	}
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String details;
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	

}
