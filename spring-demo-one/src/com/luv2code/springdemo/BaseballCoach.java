package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
//	Define a Private for the Dependency
	private FortuneService fortuneService;
	
	public BaseballCoach() {};
//	Define a Constructor for Dependency Injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Baseball Coach says: Get to work!!!";
	}

	@Override
	public String getDailyFortune() {
		// use fortune service to get the getFortune() 
		// Cual Fortune se usara? La Injectada en applicationContext.xml
		return fortuneService.getFortune();
	}
	

}
