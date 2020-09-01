package com.harry.springaop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.harry.springaop.Account;

@Aspect
@Component
@Order(1)
public class AnalyseAspect {

    @Before("com.harry.springaop.aspect.PointcutsContainer.forDAOExclusive()")
    public void analyise(JoinPoint joinPoint) {
	System.out.println("=======> anaylyse()");

	MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

	System.out.println("Method: " + methodSignature);

	Object[] args = joinPoint.getArgs();

	for (Object arg : args) {
	    System.out.println(arg);
	}
    }

    @AfterReturning(pointcut = "execution(* com.harry.springaop.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, List<Account> result) {

	System.out.println("=======> After returning");

	String method = joinPoint.getSignature().toShortString();

	System.out.println("method: " + method);

	System.out.println("res + " + result);

	for (Account account : result) {
	    account.setName(account.getName().toUpperCase());
	}

	System.out.println("res + " + result);

    }

    @AfterThrowing(pointcut = "execution(* com.harry.springaop.dao.AccountDAO.findAccounts(..))", throwing = "err")
    public void afterThrowing(JoinPoint joinPoint, Throwable err) {
	System.out.println("=======> After throwing");

	String method = joinPoint.getSignature().toShortString();

	System.out.println("method: " + method);

	System.out.println(err);
    }

    @After("execution(* com.harry.springaop.dao.AccountDAO.findAccounts(..))")
    public void after() {
	System.out.println("=======> After(finally) block");
    }

    @Around("execution(* com.harry.springaop.service.*.getFortune(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

	System.out.println("=======> After throwing");

	String method = proceedingJoinPoint.getSignature().toShortString();

	System.out.println("	->method: " + method);

	long before = System.currentTimeMillis();

	Object res = proceedingJoinPoint.proceed();

	long after = System.currentTimeMillis();

	long duration = after - before;

	System.out.println("	-> Duration : " + duration);

	return res;

    }
}
