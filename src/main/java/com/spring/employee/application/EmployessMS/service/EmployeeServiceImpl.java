package com.spring.employee.application.EmployessMS.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employee.application.EmployessMS.dto.EmployeeDTo;
import com.spring.employee.application.EmployessMS.entity.Employee;
import com.spring.employee.application.EmployessMS.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTo saveEmployee(EmployeeDTo employeeDto) {
		log.info("Save Employee Started ");
		return Employee.employeeDto(employeeRepository.save(employeeDto.toEmployee()));
	}

	@Override
	public List<EmployeeDTo> getAllEmployee() {
		var list = employeeRepository.findAll();
		log.info("Find All Employees Started ");
		return list.stream().map(a -> a.employeeDto(a)).toList();
	}

	@Override
	public EmployeeDTo getEmployeeById(String id) {
		log.info("Find by Employee ID Started ");
		var emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return Employee.employeeDto(emp.get());
		}
		return new EmployeeDTo();
	}

}
