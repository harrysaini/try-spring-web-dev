package com.harry.springannotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] fortunes = { "Keep safe from behind attack", "Eat full everytime", "Go to trip each month" };

	private Random randomNumberGenerator = new Random();

	@Override
	public String getFortune() {
		return fortunes[randomNumberGenerator.nextInt(fortunes.length)];
	}

}
