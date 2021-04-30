package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	//Fields for literal Values:
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("Inside EMPTY constructor");
	}
	
	
	// Setter Method used for our Dependency Injection
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside our SETTER Method");
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}


	@Override
	public String getDailyWorkout() {
		return "Overriding from CRICKET COACH";
	}

	@Override
	public String getDailyFortune() {
		return "Cricket Coach says: " + fortuneService.getFortune();
	}

}
