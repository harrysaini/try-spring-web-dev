package com.harry.basicdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String team;
	private String emailAddress;

	public CricketCoach() {
		System.out.println("CricketCoach: constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Bowl super fast, dhoni helicopter";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: setFortuneService");
		this.fortuneService = fortuneService;
	}

	public String getEmailAddressA(Object a) {
		System.out.println(a);
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: setTeam");
		this.team = team;
	}

}
