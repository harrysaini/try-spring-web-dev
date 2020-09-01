package com.harry.springaop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harry.springaop.dao.AccountDAO;
import com.harry.springaop.service.TrafficFortuneService;

public class AfterReturningDemo {

    public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

	AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

	afterReturningDemo(accountDAO);

	System.out.println("\n\n\n--------------\n\n");

	afterThrowingDemo(accountDAO);

	System.out.println("\n\n\n--------------\n\n");

	aroundAdviceDemo(context);
    }

    private static void aroundAdviceDemo(AnnotationConfigApplicationContext context) {
	TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
		TrafficFortuneService.class);

	System.out.println("Getting fortune");

	String fortune = trafficFortuneService.getFortune();

	System.out.println("Fortune is: " + fortune);

	System.out.println("Finished");

	context.close();
    }

    private static void afterReturningDemo(AccountDAO accountDAO) {
	List<Account> accounts = accountDAO.findAccounts(false);

	System.out.println("-> Main");
	System.out.println(accounts);
    }

    private static void afterThrowingDemo(AccountDAO accountDAO) {
	List<Account> accounts = null;

	try {

	    accounts = accountDAO.findAccounts(true);
	    System.out.println(accounts);
	} catch (Exception e) {
	    System.out.println("-> Main exception");
	    System.out.println(e);
	}

    }

}
