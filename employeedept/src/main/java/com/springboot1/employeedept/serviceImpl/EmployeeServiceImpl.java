package com.springboot1.employeedept.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot1.employeedept.models.Address;
import com.springboot1.employeedept.entity.Department;
import com.springboot1.employeedept.entity.Employee;
import com.springboot1.employeedept.exception.ResourceNotFoundException;
import com.springboot1.employeedept.external.services.AddressService;
import com.springboot1.employeedept.repository.EmployeeRepository;
import com.springboot1.employeedept.service.DepartmentService;
import com.springboot1.employeedept.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private AddressService addressService;
	@Autowired
	private DepartmentService deptService;
//	@Autowired
//	private Employee employee1;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		

		Department deptObj = deptService.saveDepartment(employee.getDepartment());
		employee.setDept_Id(deptObj.getId());

		Address addObj = addressService.saveAddress(employee.getAddress());
		employee.setAdd_id(addObj.getId());
		
		Employee createdEmployee = employeeRepo.save(employee);
		
		return createdEmployee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = employeeRepo.findAll();
		for (int i = 0; i < employeeList.size(); i++) {			
			Employee emp =  employeeList.get(i);
			emp.setAddress(addressService.getAddress(emp.getAdd_id()));
			emp.setDepartment(deptService.getDepartment(emp.getDept_Id()));
		}
	
		return employeeList;
	}

	@Override
	public Employee getEmployee(Long empid) {
		Employee emp = employeeRepo.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "Id", empid));
		
		emp.setAddress(addressService.getAddress(emp.getAdd_id()));
		emp.setDepartment(deptService.getDepartment(emp.getDept_Id()));
		return emp;
	}

	@Override
	public Employee updateEmployee(Long empid, Employee employee) {
		Employee emp = employeeRepo.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "Id", empid));
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setAddress(employee.getAddress());
		emp.setJoining_date(employee.getJoining_date());
		emp.setInserted_on(employee.getInserted_on());
		emp.setUpdated_on(employee.getUpdated_on());
		
		deptService.updateDepartment(emp.getDept_Id(), employee.getDepartment());
		addressService.updateAddress(emp.getAdd_id(), employee.getAddress());
		
		
		Employee updatedEmployee=employeeRepo.save(emp);

		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(Long empid) {
		Employee emp1 = employeeRepo.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "Id", empid));
		
		this.employeeRepo.delete(emp1);

		
	}
	
	

}
