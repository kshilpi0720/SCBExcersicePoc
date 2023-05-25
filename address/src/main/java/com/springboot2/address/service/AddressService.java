package com.springboot2.address.service;

import java.util.List;

import com.springboot2.address.entity.Address;


public interface AddressService {

	Address saveAddress(Address address);
	List<Address> getAllAddress();
	Address getAddress(long addid);
	Address updateAddress(long addid, Address address);
	String deleteAddress(long addid);
}
