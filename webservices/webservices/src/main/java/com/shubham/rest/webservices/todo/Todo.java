package com.shubham.rest.webservices.todo;

import java.util.Date;
import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String username;
	private Date targetDate;
	private boolean isDone;
	
	protected Todo() {
		
	}
	
	public Todo(Long id, String description, String username, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.description = description;
		this.username = username;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}
	
	public Long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(id, other.id);
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	

}
