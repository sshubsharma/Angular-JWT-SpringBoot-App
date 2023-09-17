package com.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.departmentservice.entity.Department;
import com.departmentservice.service.DeprtService;




@RestController
@RequestMapping("/departments")
public class DeptController {
	
	@Autowired
	public DeprtService deprtService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		return deprtService.saveDepartment(department);
	}
	
	@GetMapping("/{deptId}")
	public Department findDepartmentById(@PathVariable("deptId") Long deptId) {
		return deprtService.findDepartmentById(deptId);
	}

}
