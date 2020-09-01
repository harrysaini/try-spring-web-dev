package com.harry.springdemo.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.harry.springdemo.controllers.*.*(..))")
    private void forController() {

    }

    @Pointcut("execution(* com.harry.springdemo.service.*.*(..))")
    private void forService() {

    }

    @Pointcut("execution(* com.harry.springdemo.dao.*.*(..))")
    private void forDAO() {

    }

    @Pointcut("forController() || forService() || forDAO()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    private void beforeAdvice(JoinPoint joinPoint) {

	String method = joinPoint.getSignature().toShortString();

	logger.info("=====> @Before advice ||| method: " + method);

	Object[] args = joinPoint.getArgs();

	logger.info("===> Argumnets" + args);
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
	String method = joinPoint.getSignature().toShortString();

	logger.info("=====> @AfterReturning advice ||| method: " + method);

	logger.info("===> Returning " + result);
    }

}
