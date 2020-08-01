package com.harry.basicdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		
		System.out.println(coach.getDailyFortune());

		context.close();

	}

}