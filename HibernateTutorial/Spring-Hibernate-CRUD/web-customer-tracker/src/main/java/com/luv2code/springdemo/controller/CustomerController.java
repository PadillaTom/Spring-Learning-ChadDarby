package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// *** Injecting Customer Service
	@Autowired
	private CustomerService customerService;
	
	
	// *** VIEW ALL Customers ***
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get Customers from SERVICE (which delegates to DAO):
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Add Customers to my Spring MVC Model:
		theModel.addAttribute("customers", theCustomers); 
		// Returns this "customers" and have to call it from JSP
		
		return "list-customers";
	}
	
	// *** ADD Customer Page ***
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// New Model Attribute to bind form data:
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	// *** SAVE Customer ***
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		// Saving Customer, using our SERVICE:
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	// *** VIEW Update Page ***
	@GetMapping("/showFormForUpdate")
	public String showFormForUdpate(@RequestParam("customerId") int theId,Model theModel) {
		// Getting Customer from SERVICE:
		Customer theCustomer = customerService.getCustomer(theId);
		
		// Set Model to Populate Form:
		theModel.addAttribute("customer", theCustomer);
		
		// Send to our Form
		return "customer-form";
	}
	
	
	
}
