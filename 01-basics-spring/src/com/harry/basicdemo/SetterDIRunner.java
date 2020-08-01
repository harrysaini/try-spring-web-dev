package com.harry.basicdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDIRunner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);

		System.out.println(coach.getDailyWorkout());

		System.out.println(coach.getDailyFortune());

		System.out.println(coach.getTeam());

		System.out.println(coach.getEmailAddressA(4));

		context.close();

	}

}
