package com.harry.basicdemo;

public class RandomFortuneService implements FortuneService {

	private static String[] fortunes = { "You will win price today", "You will meet love today",
			"You will have an surprise" };

	@Override
	public String getDailyFortune() {
		int rand = (int) ((Math.random() * 100) % 3);
		return fortunes[rand];
	}

}
