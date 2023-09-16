package com.shubham.rest.webservices.dbservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>,EmployeeRepositoryCustom{
	

}
