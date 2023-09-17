package com.departmentservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.departmentservice.entity.Department;

@Repository
public interface DeptRepository extends JpaRepository<Department,Long>{

	public Department findDepartmentBydeptId(Long deptId);

}
