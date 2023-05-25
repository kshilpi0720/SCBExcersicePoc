package com.springboot1.employeedept.exception;

public class ResourceNotFoundException extends RuntimeException{
//	String resourceName;
//	String fieldName; 
	public ResourceNotFoundException(String resourceName, String feildName, long empId)
	{
		super(String.format("%s is  not fount with %s:%s ",resourceName,feildName,empId));
	}
}
