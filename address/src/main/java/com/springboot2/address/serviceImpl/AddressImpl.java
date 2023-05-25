package com.springboot2.address.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot2.address.entity.Address;
import com.springboot2.address.exception.ResourceNotFoundException;
import com.springboot2.address.repository.AddressRepository;
import com.springboot2.address.service.AddressService;

@Service
public class AddressImpl implements AddressService {
	@Autowired
	private AddressRepository addressrepo;

	@Override
	public Address saveAddress(Address address) {
		Address createAddress = addressrepo.save(address);
		return createAddress;
	}

	@Override
	public List<Address> getAllAddress() {
		List<Address> getAddress = addressrepo.findAll();
		return getAddress;
	}

	@Override
	public Address getAddress(long addid) {
		Address getByIdAddress = addressrepo.findById(addid)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "Id", addid));
		return getByIdAddress;
	}

	@Override
	public Address updateAddress(long addid, Address address) {
		Address add=addressrepo.findById(addid)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "Id", addid));
		add.setAddress_line1(address.getAddress_line1());
		add.setAddress_Line2(address.getAddress_Line2());
		add.setArea(address.getArea());
		add.setCity(address.getCity());
		add.setState(address.getState());
		add.setPincode(address.getPincode());
		Address updatedAddress=addressrepo.save(add);
		return updatedAddress;
	}

	@Override
	public String deleteAddress(long addid) {
		Address add=addressrepo.findById(addid)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "Id", addid));
		this.addressrepo.delete(add);
		return "Address with Id: "+ addid+" Deleted";
	}


}
