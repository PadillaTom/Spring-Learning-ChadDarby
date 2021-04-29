package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// Create Object
		Coach firstCoach = new BaseballCoach();
		Coach secondCoach = new TrackCoach();
		
		
		// Use the Object
		System.out.println(firstCoach.getDailyWorkout());
		System.out.println(secondCoach.getDailyWorkout());

	}

}
