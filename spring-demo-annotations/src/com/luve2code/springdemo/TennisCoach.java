package com.luve2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	//Fields
	@Autowired
	private FortuneService fortuneService;	
	
	//Constructors:
	public TennisCoach() {
		// TODO Auto-generated EMPTY constructor stub
	}
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
	// Setters for Injections:
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
//	
	
	// Methods:

	@Override
	public String getDailyWorkout() {		
		return "Tennis Coach getDailyWorkout()";
	}

	@Override
	public String getDailyFortune() {
		return "TennisCoach.getDailyFortune() which calls fortuneService.getFortune(): " + fortuneService.getFortune();
	}
	

}
