package com.harry.beanScopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.harry.basicdemo.Coach;

public class BeanLifeCycleRunner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycleAppContext.xml");

		Coach myCoach = context.getBean("myCoach", Coach.class);

		System.out.println(myCoach.getDailyWorkout());

		System.out.println(myCoach.getDailyFortune());

		context.close();

	}

}
