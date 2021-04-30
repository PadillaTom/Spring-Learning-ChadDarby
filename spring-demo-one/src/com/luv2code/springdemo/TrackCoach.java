package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {};
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Track Coach says: RUN mtf RUN!!!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "overriding wohooo " + fortuneService.getFortune();
	}
	
	//*** Methods for Beans LIFECYCLE ****
	public void doMyInitStuff(){
		System.out.println("TRACKCOACH --- Doing INIT Stuff");
	}	
	public void doMyDestroyStuff() {
		System.out.println("TRACKCOACH --- Doing DESTROY Stuff");
	}

}
