package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	//Fields
	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	
	//Constructor
	public Student() {
		
		// Creamos el LinkedHashMap (Lista de paises):
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("ARG", "Argentina");
		countryOptions.put("PE", "Peru");
		countryOptions.put("CH", "Switzerland");
		countryOptions.put("FR", "France");
	}

	//Getters and Setters
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	
	
}
