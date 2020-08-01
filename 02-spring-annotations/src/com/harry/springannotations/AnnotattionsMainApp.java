package com.harry.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotattionsMainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach myCoach = context.getBean("myCoach", Coach.class);

		System.out.println(myCoach.getDailyWorkout());

		System.out.println(myCoach.getDailyFortune());

		Coach myCoach2 = context.getBean("cricketCoach", Coach.class);

		System.out.println(myCoach2.getDailyWorkout());

		System.out.println(myCoach2.getDailyFortune());

		context.close();

	}

}
