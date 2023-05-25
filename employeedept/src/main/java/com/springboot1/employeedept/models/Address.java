package com.springboot1.employeedept.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private int Id;
	private String address_line1;
	private String address_Line2;
	private String area;
	private String State;
	private String city;
	private String pincode;
}
