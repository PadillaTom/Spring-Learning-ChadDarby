package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// Load Spring Config File
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve Bean from Spring Container
		CricketCoach myCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// Call methods on the Bean
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		// Getting the values we just SET
		System.out.println(myCoach.getEmailAddress());
		System.out.println(myCoach.getTeam());
		
		// Close Context
		context.close();
	}

}
