package com.springboot1.employeedept.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot1.employeedept.models.Address;

@FeignClient(name = "ADDRESS-SERVICE")
public interface AddressService {

	@GetMapping("/api/address/{addid}")
	Address getAddress(@PathVariable long addid);

	@PostMapping("/api/address/")
	Address saveAddress(@RequestBody Address Address);

	@PutMapping("/api/address/{addid}")
	Address updateAddress(@PathVariable long addid, @RequestBody Address Address);

}
