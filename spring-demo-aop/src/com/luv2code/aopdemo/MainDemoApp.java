package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// Read Spring Configuration Class:
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get Bean form Container:
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Call business method:
		theAccountDAO.addAccount();
		
		// Close Context:
		context.close();
	}

}
