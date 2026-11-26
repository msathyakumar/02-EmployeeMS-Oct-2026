package com.spring.employee.application.EmployessMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.employee.application.EmployessMS.dto.EmployeeDTo;

@Service
public interface EmployeeService {

	EmployeeDTo saveEmployee(EmployeeDTo employeeDto);

	List<EmployeeDTo> getAllEmployee();

	EmployeeDTo getEmployeeById(String id);
	
	

}
