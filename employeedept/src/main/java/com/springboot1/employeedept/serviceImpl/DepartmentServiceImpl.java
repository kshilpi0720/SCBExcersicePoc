package com.springboot1.employeedept.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot1.employeedept.entity.Department;
import com.springboot1.employeedept.exception.ResourceNotFoundException;
import com.springboot1.employeedept.repository.DepartmentRepository;
import com.springboot1.employeedept.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public Department saveDepartment(Department department) {
		Department creaatedDepartment = departmentRepo.save(department);
		return creaatedDepartment;
	}

	@Override
	public List<Department> getAllDepartment() {

		return this.departmentRepo.findAll();
	}

	@Override
	public Department getDepartment(Long deptid) {
		Department getById=departmentRepo.findById(deptid)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "Id", deptid));
		return getById;
	}

	@Override
	public Department updateDepartment(Long deptid, Department department) {
		Department dept=departmentRepo.findById(deptid)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "Id", deptid));
		dept.setName(department.getName());
		Department updatedDept=departmentRepo.save(dept);
		return updatedDept;
	}

	@Override
	public String deleteDepartment(Long deptid) {
		Department deleteDept=departmentRepo.findById(deptid)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "Id", deptid));
		this.departmentRepo.delete(deleteDept);
		return "Department with Id: "+deptid+" deleted";
	}

}
