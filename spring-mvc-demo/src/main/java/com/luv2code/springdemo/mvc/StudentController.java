package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

//	**************************
//  *** Show the Form page ***
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		// Create Student Object
		Student theStudent = new Student();
		// Add it to Model
		theModel.addAttribute("student",theStudent);
		
		return "student-form";
	}

//	**********************************
//	*** Process the Form Submitted ***
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
//		// Log for DEBUGGING:
//		System.out.println("The Student: " + theStudent.getFirstName() + " " + theStudent.getLastName() );
		
		// Returning VIEW
		return "student-confirmation";
	}
	
	
}
