package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// Load Spring Configuration File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve Bean
		Coach firstCoach = context.getBean("myCoach", Coach.class);
		
		// Call Methods of the Bean
		System.out.println(firstCoach.getDailyWorkout());
		// By using dependency injection my firstCoach can access getDailyFortune
		System.out.println(firstCoach.getDailyFortune());
		
		// Close Context
		context.close();
		

	}

}
