package com.harry.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingAspect {

////    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.harry.springaop.dao.AccountDAO.addAccount())")
////    @Before("execution(public void add*())")
////    @Before("execution(public void com.harry.springaop.dao.*.*(..))")
////  @Before("execution(public void *(com.harry.sprinfdemo.Account))")
//    public void loggingHelper() throws Exception {
//	System.out.println("@Before(\"execution(public void addAccount())\") Executing before advice");
//
////	throw new Exception("hello");
//    }
//
//    

    @Before("execution(public * *(..))")
    public void loggingHelper() throws Exception {
	System.out.println("=======> @Before(\"execution(public void addAccount())\") Executing before advice");

    }

}
