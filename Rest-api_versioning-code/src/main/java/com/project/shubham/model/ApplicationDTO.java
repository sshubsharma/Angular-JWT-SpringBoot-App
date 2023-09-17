package com.project.shubham.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class ApplicationDTO {
	
	@Id
	@GeneratedValue
	private int id;
	
	//spring validation
	@Size(min = 2,message = "name should have atleaste 2 charecter")
	private String firstName;
	
	private String lastName;
	private int rollNumber;
	private String country;
	protected ApplicationDTO() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public ApplicationDTO(int id, String firstName, String lastName, int rollNumber, String country) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNumber = rollNumber;
		this.country = country;
	}
	public String getCountry() {
		return country;
	}
	@Override
	public String toString() {
		return "ApplicationDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rollNumber="
				+ rollNumber + ", country=" + country + "]";
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
