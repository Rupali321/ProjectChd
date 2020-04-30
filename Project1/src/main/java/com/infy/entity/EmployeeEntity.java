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
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer employeeId;
		private String name;
		private String lastName;
		private String emailId;
		private String mobileNo;
		
		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public Integer getEmployeeId() {
			return employeeId;
		}
		
		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		
		
		
}
