package com.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departmentservice.entity.Department;
import com.departmentservice.repository.DeptRepository;

@Service
public class DeprtService {
	
	@Autowired
	private DeptRepository deptRepository;

	public Department saveDepartment(Department department) {
		return deptRepository.save(department);
	}

	public Department findDepartmentById(Long deptId) {
		return deptRepository.findDepartmentBydeptId(deptId);
	}

}
