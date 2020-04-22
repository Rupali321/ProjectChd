package com.infy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.Model.Employee;
import com.infy.service.EmployeeImplService;

@CrossOrigin
@RestController
@RequestMapping("EmployeeAPI")
public class EmployeeImplAPI {
	
	
	@Autowired
	private EmployeeImplService employeeImplService;
	
	@Autowired
	private Environment environment;
	 @GetMapping(value = "getEmployee/{employeeId}")
	   public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") Integer employeeId) throws Exception {
	 
	       try
	       {
	    	   Employee employee = employeeImplService.getEmployee(employeeId);
	           return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	           
	       }
	       catch (Exception e) {
	           
	           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
	       }
	   }
	

}
