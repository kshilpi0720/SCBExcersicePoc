package com.springboot1.employeedept.entity;

import java.util.Date;
import java.util.List;

import com.springboot1.employeedept.models.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "EMPLOYEE")
public class Employee {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(name = "DEPT_Id")
	private long Dept_Id;
	@Column(name = "NAME")
	private String name;
	private int salary;
	@Column(name = "JOINING_DATE")
	private Date joining_date;
	@Column(name = "ADD_ID")
	private Long Add_id;
	@Transient
	@Column(name = "INSERTED_ON")
	private int Inserted_on;
	@Transient
	@Column(name = "UPDATED_ON")
	private int updated_on;
	@Transient
	@OneToOne
	private Department department;
	@Transient
	private Address address;
//	@Transient
//	private List<Address> address;

}
