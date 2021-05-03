package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	//Fields
	private String firstName;
	
	@NotNull(message = "Is Required")
	@Size(min=1, message = "Is Required")
	private String lastName;
	
	@NotNull(message = "Is Required")
	@Min(value=1, message = "Must have at least 1 Pass to enter")
	@Max(value= 10, message = "10 is the Max Passes you can have")
	private Integer freePasses;
	
	//G and S
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}	
	
}
