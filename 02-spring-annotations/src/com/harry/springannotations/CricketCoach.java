package com.harry.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	public CricketCoach() {
		System.out.println("CricketCoach constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Bat till century";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("CricketCoach setFortuneService");
//		this.fortuneService = fortuneService;
//	}

}
