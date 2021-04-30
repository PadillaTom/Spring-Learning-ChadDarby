package com.luve2code.springdemo;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService theFortunseService) {
		fortuneService = theFortunseService;
	}
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "SWIM COACH: getDailyWorkout()";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "SWIM COACH: getDailyFortune() + running getFortune(): " + fortuneService.getFortune();
	}

}
