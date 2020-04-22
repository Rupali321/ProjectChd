package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.Model.Employee;
import com.infy.dao.EmployeeImplDao;

@Service(value = "EmployeeImplService")
@Transactional
public class EmployeeImplService {
	
	@Autowired
	private EmployeeImplDao employeeImplDao ;

	public Employee getEmployee(Integer employeeId) throws Exception
	{
		Employee employeefromDB=employeeImplDao.getEmployeeDetail(employeeId);
		if(employeefromDB==null) {
			throw new Exception("EmployeeImplService.NO_EMPLOYEE");
		}
		return employeefromDB;
	}

}
