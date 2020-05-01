package com.infy.service;

import java.util.List;

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
	
	public List<Employee> getEmployeeDetails() throws Exception
	{
		List<Employee> employeefromDB=employeeImplDao.getAllEmployeeDetails();
		if(employeefromDB==null) {
			throw new Exception("EmployeeImplService.NO_EMPLOYEE");
		}
		return employeefromDB;
	}
	public Employee updateEmployee(Integer employeeId,Employee employeeDetails) throws Exception
	{Employee emp1=null;
	 Employee emp2=null;
		Employee employeefromDB=employeeImplDao.getEmployeeDetail(employeeId);
		emp1=employeeImplDao.getEmployeeEmailId(employeeDetails.getEmailId());
		emp2=employeeImplDao.getEmployeeMobile(employeeDetails.getMobileNo());

		if(employeefromDB!=null) {
			if(emp1!=null) {
				throw new Exception("EmployeeImplService.EMAILID_ALREADY_EXISTS");

			}
			else if(emp2!=null)
			{
				throw new Exception("EmployeeImplService.PHONE_NO_ALREADY_EXISTS");
			}
			else {
			employeeImplDao.updateEmployee(employeeId,employeeDetails);
			}
			}
		else if (employeefromDB==null)
			{
				throw new Exception("EmployeeImplService.NO_EMPLOYEE");
			}
		
		return employeefromDB;
	}
	
	public Employee deleteEmployee(Integer employeeId) throws Exception
	{
		Employee employeefromDB=employeeImplDao.getEmployeeDetail(employeeId);
		if(employeefromDB!=null) {
			employeeImplDao.deleteEmployee(employeeId);}
		else if (employeefromDB==null)
			{
				throw new Exception("EmployeeImplService.NO_EMPLOYEE");
			}
		
		return employeefromDB;
	}
	public Integer createEmployee(Employee employeeDetails) throws Exception
	{	System.out.println("entering service class");
	Employee emp1=null;
	Employee emp2=null;
	emp1=employeeImplDao.getEmployeeEmailId(employeeDetails.getEmailId());
		emp2=employeeImplDao.getEmployeeMobile(employeeDetails.getMobileNo());

		
			if(emp1!=null) {
				System.out.println("entering loop email check");
			throw new Exception("EmployeeImplService.EMAILID_ALREADY_EXISTS");

		}
		else if(emp2!=null)
			{
				throw new Exception("EmployeeImplService.PHONE_NO_ALREADY_EXISTS");
				}
			else 
			{
				return employeeImplDao.createEmployee(employeeDetails);	
			}
		
		
//		if(employeefromDB!=null) {
//			employeeImplDao.updateEmployee(employeeId,employeeDetails);}
//		else if (employeefromDB==null)
//			{
//				throw new Exception("EmployeeImplService.NO_EMPLOYEE");
//			}
//		
//		return employeefromDB;
	 }
	}

