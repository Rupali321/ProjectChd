package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="Employee")
public class EmployeeEntity {
	
	
	
		@Id
		@JoinColumn(name="employee_Id")	
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private String employeeId;
		@JoinColumn(name="name")
		private String name;
		@JoinColumn(name="mobile_no")
		private String mobileno;
		
		public String getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMobileno() {
			return mobileno;
		}
		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}
		
		
}
