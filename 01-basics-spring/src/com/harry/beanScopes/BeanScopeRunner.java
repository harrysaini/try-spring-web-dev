package com.harry.beanScopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.harry.basicdemo.Coach;

public class BeanScopeRunner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeAppContext.xml");

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
