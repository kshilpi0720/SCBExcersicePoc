package com.springboot1.employeedept.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot1.employeedept.models.Address;
import com.springboot1.employeedept.entity.Employee;
import com.springboot1.employeedept.exception.ResourceNotFoundException;
import com.springboot1.employeedept.external.services.AddressService;
import com.springboot1.employeedept.repository.EmployeeRepository;
import com.springboot1.employeedept.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private AddressService addressService;
//	@Autowired
//	private Employee employee1;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee createEmployee = employeeRepo.save(employee);
		return createEmployee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> getAllEmployee = employeeRepo.findAll();
		return getAllEmployee;
	}

	@Override
	public Employee getEmployee(Long empid) {
		Employee emp = employeeRepo.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "Id", empid));
		
		Address adrs=addressService.getAddress(emp.getAdd_id());
		emp.setAddress(adrs);
		return emp;
	}

	@Override
	public Employee updateEmployee(Long empid, Employee employee) {
		Employee emp = employeeRepo.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "Id", empid));
		emp.setDept_Id(employee.getDept_Id());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setAddress(employee.getAddress());
		emp.setJoining_date(employee.getJoining_date());
		emp.setInserted_on(employee.getInserted_on());
		emp.setUpdated_on(employee.getUpdated_on());
		
		
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
