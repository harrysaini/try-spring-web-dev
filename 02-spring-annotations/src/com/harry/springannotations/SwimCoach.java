package com.harry.springannotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	@Value("${coach.email}")
	private String team;

	@Value("${coach.team}")
	private String email;

	public SwimCoach(FortuneService fortuneService) {
		System.out.println("SwimCoach constructors");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 100 m";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getTeam() {
		return team;
	}

	public String getEmail() {
		return email;
	}

}
