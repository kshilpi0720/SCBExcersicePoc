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
import com.springboot1.employeedept.service.DepartmentService;

@RestController
@RequestMapping("api/dept")
public class DepartmentController {
	@Autowired
	private DepartmentService deptservice;
	//create Department
	@PostMapping("/")
	public Department createDepartment(@RequestBody Department department)
	{
		Department createdDept=this.deptservice.saveDepartment(department);
		return createdDept;
		
	}
	//getall Department
	@GetMapping("/")
	public List<Department> getAllDepartment()
	{
		List<Department> getAllDept=this.deptservice.getAllDepartment();
		return getAllDept;
		
	}
	//get by id
	@GetMapping("/{deptid}")
	public Department getDepartment(@PathVariable Long deptid)
	{
		Department GetByIdDept=this.deptservice.getDepartment(deptid);
		return GetByIdDept;
		
	}
	//update
	@PutMapping("/{deptid}")
	public Department updateDepartment(@PathVariable Long deptid,@RequestBody Department department)
	{
		Department updatedDept=this.deptservice.updateDepartment(deptid,department);
		return updatedDept;
		
	}
	// delete
	@DeleteMapping("/{deptid}")
	public String deleteDepartment(@PathVariable Long deptid)
	{
		
		return this.deptservice.deleteDepartment(deptid);
		
	}
}
