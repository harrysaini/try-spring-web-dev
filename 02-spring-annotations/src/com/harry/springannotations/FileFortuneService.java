package com.harry.springannotations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private List<String> fortunes;

	@PostConstruct
	private void setup() {
		System.out.println("FileFortune service setup");
		Path filePath = Path.of("./resources/data.txt");

		try {
			List<String> fortunes = Files.readAllLines(filePath);
			this.fortunes = fortunes;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Random randomNumberGenerator = new Random();

	@Override
	public String getFortune() {
		return fortunes.get(randomNumberGenerator.nextInt(fortunes.size()));
	}

}
