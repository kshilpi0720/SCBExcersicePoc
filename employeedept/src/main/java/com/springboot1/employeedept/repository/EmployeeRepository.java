package com.springboot1.employeedept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot1.employeedept.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
