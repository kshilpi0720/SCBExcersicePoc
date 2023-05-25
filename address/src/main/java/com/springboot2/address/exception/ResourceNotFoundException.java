package com.springboot2.address.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String resourceName, String feildName, long empId)
	{
		super(String.format("%s is  not fount with %s:%s ",resourceName,feildName,empId));
	}
}
