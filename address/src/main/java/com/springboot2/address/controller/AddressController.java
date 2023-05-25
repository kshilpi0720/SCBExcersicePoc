package com.springboot2.address.controller;

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

import com.springboot2.address.entity.Address;
import com.springboot2.address.service.AddressService;



@RestController
@RequestMapping("/api/address")
public class AddressController {
	@Autowired
	private AddressService addservice;
	//create Department
	@PostMapping("/")
	public Address createAddress(@RequestBody Address Address)
	{
		Address createdadd=this.addservice.saveAddress(Address);
		return createdadd;
		
	}
	//getall Department
	@GetMapping("/")
	public List<Address> getAllAddress()
	{
		List<Address> getAllAdd=this.addservice.getAllAddress();
		return getAllAdd;
		
	}
	//get by id
	@GetMapping("/{addid}")
	public Address getAddress(@PathVariable int addid)
	{
		Address GetByIdAdd=this.addservice.getAddress(addid);
		return GetByIdAdd;
		
	}
	//update
	@PutMapping("/{addid}")
	public Address updateDepartment(@PathVariable int addid,@RequestBody Address Address)
	{
		Address updatedAdd=this.addservice.updateAddress(addid, Address);
		return updatedAdd;
		
	}
	// delete
	@DeleteMapping("/{addid}")
	public String deleteDepartment(@PathVariable int addid)
	{
		
		return this.addservice.deleteAddress(addid);
		
	}

}
