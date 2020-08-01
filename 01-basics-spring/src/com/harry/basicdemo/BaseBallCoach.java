package com.harry.basicdemo;

public class BaseBallCoach implements Coach {
	
	private FortuneService fortuneService;

	public BaseBallCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run my boy";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}
}
