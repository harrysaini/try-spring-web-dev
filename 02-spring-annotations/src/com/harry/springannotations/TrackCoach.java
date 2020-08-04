package com.harry.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myCoach")
@Scope("prototype")
public class TrackCoach implements Coach {

	@Value("${coach.name}")
	private String name;

	private FortuneService fortuneService;

	@Autowired
	private TrackCoach(@Qualifier("fileFortuneService") FortuneService fortuneService) {
		System.out.println("TRACK COACH constructors");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return name + " I am, go run like hell boy";
	}

	@Override
	public String getDailyFortune() {
		return name + ": " + fortuneService.getFortune();
	}

}
