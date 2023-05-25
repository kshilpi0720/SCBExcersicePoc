package com.springboot2.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot2.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
