package com.harry.springaop;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harry.springaop.dao.AccountDAO;
import com.harry.springaop.service.TrafficFortuneService;

public class AfterReturningDemo {
    
    private static Logger logger = Logger.getLogger(AfterReturningDemo.class.getName());
    

    public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

	AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

	afterReturningDemo(accountDAO);

	logger.info("\n\n\n--------------\n\n");

	afterThrowingDemo(accountDAO);

	logger.info("\n\n\n--------------\n\n");

	aroundAdviceDemo(context);
    }

    private static void aroundAdviceDemo(AnnotationConfigApplicationContext context) {
	TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
		TrafficFortuneService.class);

	logger.info("Getting fortune");

	String fortune = trafficFortuneService.getFortune();

	logger.info("Fortune is: " + fortune);

	logger.info("Finished");

	context.close();
    }

    private static void afterReturningDemo(AccountDAO accountDAO) {
	List<Account> accounts = accountDAO.findAccounts(false);

	logger.info("-> Main");
	logger.info(accounts.toString());
    }

    private static void afterThrowingDemo(AccountDAO accountDAO) {
	List<Account> accounts = null;

	try {

	    accounts = accountDAO.findAccounts(true);
	    logger.info(accounts.toString());
	} catch (Exception e) {
	    logger.info("-> Main exception");
	    logger.info(e.toString());
	}

    }

}
