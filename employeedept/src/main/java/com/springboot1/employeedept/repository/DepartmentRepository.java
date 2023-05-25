package com.springboot1.employeedept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot1.employeedept.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
