package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// *** Injecting Customer Service
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get Customers from SERVICE (which delegates to DAO):
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Add Customers to my Spring MVC Model:
		theModel.addAttribute("customers", theCustomers); 
		// Returns this "customers" and have to call it from JSP
		
		return "list-customers";
	}
}
