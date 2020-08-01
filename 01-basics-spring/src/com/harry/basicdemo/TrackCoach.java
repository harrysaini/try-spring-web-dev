package com.harry.basicdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "my boy way to go";
	}

	@Override
	public String getDailyFortune() {
		return "HEY " + fortuneService.getDailyFortune();
	}

}
