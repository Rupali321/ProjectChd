package com.infy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.Model.Employee;
import com.infy.service.EmployeeImplService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("EmployeeAPI")
public class EmployeeImplAPI {

	@Autowired
	private EmployeeImplService employeeImplService;

	@Autowired
	private Environment environment;

	@PostMapping(value = "getEmployee/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer employeeId) throws Exception {

		try {
			Employee employee = employeeImplService.getEmployee(employeeId);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);

		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
	@GetMapping(value = "getAllEmployees")
	public ResponseEntity<List<Employee>> getEmployeeDetails() throws Exception {

		try {System.out.println("get all called");
			List<Employee> employee = employeeImplService.getEmployeeDetails();
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);

		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
	@PutMapping(value = "/updateEmployees/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer employeeId, @Valid @RequestBody Employee employeeDetails){
		
		try {System.out.println("hello update");
			System.out.println("updated called"+employeeDetails.getEmailId()+employeeDetails.getMobileNo()+
					employeeDetails.getEmployeeId());
		 Employee employee = employeeImplService.updateEmployee(employeeId,employeeDetails);
			String modificationSuccessMsg=environment.getProperty("EmployeeAPI.UPDATED_SUCCESSFULLY");

			return new ResponseEntity<String>(modificationSuccessMsg, HttpStatus.OK);

		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}

	}
	@DeleteMapping(value = "/deleteEmployees/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId){
		try {
		 Employee employee = employeeImplService.deleteEmployee(employeeId);
			String modificationSuccessMsg=environment.getProperty("EmployeeAPI.DELETED_SUCCESSFULY");

			return new ResponseEntity<String>(modificationSuccessMsg, HttpStatus.OK);

		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}

	}
	
	@PostMapping(value = "/createEmployees")
	public ResponseEntity<String> CreateEmployee( @RequestBody Employee employeeDetails){
		try {
			System.out.println("created called");
		Integer i=employeeImplService.createEmployee(employeeDetails);
			String modificationSuccessMsg=environment.getProperty("EmployeeAPI.employee_Created_SUCCESSFULY");

			return new ResponseEntity<String>(modificationSuccessMsg+" with id "+i, HttpStatus.OK);

		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}

	

}}
