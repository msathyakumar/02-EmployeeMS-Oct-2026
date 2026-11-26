package com.spring.employee.application.EmployessMS.entity;

import com.spring.employee.application.EmployessMS.dto.EmployeeDTo;
import com.spring.employee.application.EmployessMS.dto.Location;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	private String empId;
	private String empName;
	private String emailId;
	private String password;
	private String gender;
	private double salary;
	private String locationId;
	
	
	public static EmployeeDTo employeeDto(Employee emp) {
		
		var re=  new EmployeeDTo(emp.getEmpId(), emp.getEmpName(), emp.getEmailId(), emp.getPassword(), emp.getGender(), emp.getSalary(),new Location());
		re.getLocation().setId(emp.getLocationId());
		return re;
	}


}
