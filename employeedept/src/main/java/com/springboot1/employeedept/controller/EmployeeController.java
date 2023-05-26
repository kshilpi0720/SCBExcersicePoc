package com.springboot1.employeedept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot1.employeedept.entity.Department;
import com.springboot1.employeedept.entity.Employee;
import com.springboot1.employeedept.external.services.AddressService;
import com.springboot1.employeedept.models.Address;
import com.springboot1.employeedept.service.DepartmentService;
import com.springboot1.employeedept.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	
	@Autowired
	private AddressService addressService;

	// create employee
	@PostMapping("/")
	public Employee createEmployee(@RequestBody Employee employee) {

		
		Employee createEmployee = this.employeeService.saveEmployee(employee);
		return createEmployee;

	}
	// get all employees

	@GetMapping(path = "/", produces = "Application/xml")
	public List<Employee> getAllEmployee() {
		List<Employee> getAllEmployee = this.employeeService.getAllEmployee();
		return getAllEmployee;

	}

	// get one employee
	@GetMapping(path = "/{empid}", produces = "Application/xml")
	public Employee getEmployee(@PathVariable Long empid) {
		Employee getEmployee = this.employeeService.getEmployee(empid);
		return getEmployee;

	}

	// update employee
	@PutMapping("/{empid}")
	public Employee updateEmployee(@PathVariable Long empid, @RequestBody Employee employee) {
		
		Employee updatedEmployee = this.employeeService.updateEmployee(empid, employee);
		return updatedEmployee;

	}

	// Delete employee
	@DeleteMapping("/{empid}")
	public void detleteEmployee(@PathVariable Long empid) {
		this.employeeService.deleteEmployee(empid);
	}

}
