package com.harry.springannotations;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is sad day";
	}

}
