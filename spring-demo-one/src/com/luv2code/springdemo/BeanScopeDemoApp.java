package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// Load Spring Config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");	
		
		// Retrieve Bean from Spring Container
		Coach myCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// ** Verify the yre the same INSTANCE (Singleton) **
		boolean result = (myCoach == alphaCoach);
		System.out.println("\nPointing to the same INSTANCE of the OBJECT --> " + result);
		System.out.println("\nMemory Location for theCoach: " + myCoach);		
		System.out.println("\nMemory Location for alphaCoach: " + alphaCoach);		
		
		// Close Context
		context.close();

	}

}
