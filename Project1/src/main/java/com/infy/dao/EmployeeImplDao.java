package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public List<Employee> getAllEmployeeDetails() {
		Query query=entityManager.createQuery("select c from EmployeeEntity c");
		
		List<EmployeeEntity> l1=query.getResultList();
		List<Employee> l2=new ArrayList<Employee>();
		
		if(!l1.isEmpty()) {
			for(EmployeeEntity e2:l1) {
				Employee e1=new Employee();
				e1.setEmployeeId(e2.getEmployeeId());
				e1.setMobileno(e2.getMobileNo());
				e1.setName(e2.getName());				
				l2.add(e1);
			}
		}
		return l2;
	}
	
	public void updateEmployee(Integer employeeId, Employee employeeDetails) throws Exception
	{		EmployeeEntity employeeEntity=entityManager.find(EmployeeEntity.class, employeeId);
				employeeEntity.setMobileNo(employeeDetails.getMobileno());	
	}
	public void deleteEmployee(Integer employeeId) throws Exception
	{		EmployeeEntity employeeEntity=entityManager.find(EmployeeEntity.class, employeeId);
				entityManager.remove(employeeEntity);
	}

	public Integer createEmployee(Employee employeeDetails) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setMobileNo((employeeDetails.getMobileno()));;
		employeeEntity.setName(employeeDetails.getName());
		entityManager.persist(employeeEntity);
		//employeeEntity.setEmployeeId(e2.getEmployeeId());
		System.out.println(employeeEntity.getEmployeeId());
      return employeeEntity.getEmployeeId();
		
		
	}
	
}
