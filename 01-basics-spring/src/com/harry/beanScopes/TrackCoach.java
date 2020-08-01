package com.harry.beanScopes;

import com.harry.basicdemo.Coach;
import com.harry.basicdemo.FortuneService;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		super();
		System.out.println("TrackCoach: constructor");
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

//	CLeanup hooks

	public void onInit() {
		System.out.println("TrackCoach: startup");
	}

	public void onDestroy() {
		System.out.println("TrackCoach: destroy");
	}

}
