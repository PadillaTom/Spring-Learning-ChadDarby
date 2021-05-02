package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/helloParent")
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
	
	// Controller to read Form and add it to Model:
	@RequestMapping("/processedFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// Read Parameters:
		String  theName = request.getParameter("studentName");
		// Convert it to UpperCase
		theName = theName.toUpperCase();
		// Create a Message to be displayed
		String resultString = "Let's Scream: HEY " + theName;
		// Adding message to model
		model.addAttribute("message",resultString);
		return "helloworld";
	}
	
	// Controller to read Form and add it to Model USING REQPARAMS:
	@RequestMapping("/processedFormThree")
	public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {
		// Convert it to UpperCase
		theName = theName.toUpperCase();
		// Create a Message to be displayed
		String resultString = "Let's Scream: USING REQPARAMS --> " + theName;
		// Adding message to model
		model.addAttribute("message",resultString);
		return "helloworld";
	}
}
