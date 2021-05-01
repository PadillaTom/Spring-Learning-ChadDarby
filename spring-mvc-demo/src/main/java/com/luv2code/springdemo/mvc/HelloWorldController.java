package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	// Controller to show Initial HTML Form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// Controller to show Processed HTML Form
	@RequestMapping("/processedForm")
	public String processedForm() {
		return "helloworld";
	}
}
