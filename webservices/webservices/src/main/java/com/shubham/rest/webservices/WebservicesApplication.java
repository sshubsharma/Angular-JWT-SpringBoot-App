package com.shubham.rest.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shubham.rest.webservices.dbservice.Employee;

@SpringBootApplication
public class WebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebservicesApplication.class, args);
	}
	
	@Autowired
	private com.shubham.rest.webservices.dbservice.EmployeeRepositoryImpl EmployeeRepositoryImpl;
	
	public void run(String... arg0) throws Exception {
		List<Employee> list = EmployeeRepositoryImpl.getAllEmployees();
		for (Employee employee : list) {
			System.out.println(employee.getFirstName());
		}
	}

}
