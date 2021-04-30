package com.luve2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemo {

	public static void main(String[] args) {
		
		// Read Config 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get Beans
		Coach myCoach = context.getBean("tennisCoach", Coach.class);
		
		// Call Methods
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		
		// Close Context
		context.close();
		

	}

}
