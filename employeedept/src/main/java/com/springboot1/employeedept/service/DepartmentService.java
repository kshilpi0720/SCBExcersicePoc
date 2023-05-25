package com.springboot1.employeedept.service;

import java.util.List;

import com.springboot1.employeedept.entity.Department;



public interface DepartmentService {
	Department saveDepartment(Department department);
	List<Department> getAllDepartment();
	Department getDepartment(Long deptid);
	Department updateDepartment(Long deptid, Department department);
	String deleteDepartment(Long deptid);
}
