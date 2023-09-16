package com.shubham.rest.webservices.dbservice;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Employee> getAllEmployees() {
		StoredProcedureQuery findByYearProcedure = em.createNamedStoredProcedureQuery("getAllEmployees");
		return findByYearProcedure.getResultList();
	}

}
