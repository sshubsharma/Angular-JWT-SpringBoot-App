package com.shubham.rest.webservices.dbservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = "getAllEmployees", procedureName = "getAllEmployees", resultClasses = Employee.class) })
public class Employee {
	@Id
	@Column(name="emp_id")
	private int empId;
	private String firstName;
	private String lastname;
	private String email;
	private String address;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
