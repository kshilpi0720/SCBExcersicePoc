package com.springboot1.employeedept.service;

import java.util.List;
import java.util.Optional;

import com.springboot1.employeedept.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployee(Long empid);
	Employee updateEmployee(Long empid,Employee employee);
	void deleteEmployee(Long empId);
}
