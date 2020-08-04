package com.harry.springannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotattionBeanScopeConfigCodeApp {

	public static void main(String[] args) {
		System.out.println("MAIN START");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);

		System.out.println("GETTING COACH");

		Coach myCoach = context.getBean("myCoach", Coach.class);

		System.out.println(myCoach.getDailyWorkout());

		System.out.println(myCoach.getDailyFortune());

		Coach myCoach2 = context.getBean("myCoach", Coach.class);

		System.out.println(myCoach == myCoach2);

		System.out.println(myCoach);
		System.out.println(myCoach2);

		context.close();

	}

}
