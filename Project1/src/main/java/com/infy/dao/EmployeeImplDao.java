package com.infy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.infy.Model.Employee;
import com.infy.entity.EmployeeEntity;

@Repository(value = "EmployeeImplDAO")
public class EmployeeImplDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Employee getEmployeeDetail(Integer employeeId) {
		EmployeeEntity employeeEntity=entityManager.find(EmployeeEntity.class, employeeId);
		Employee employee = null;
		if (employeeEntity!=null) {
			employee=new Employee();
			employee.setEmployeeId(employeeId);
			employee.setName(employeeEntity.getName());
			employee.setMobileno(employeeEntity.getMobileNo());
			
		}
		return employee;
	}
}
