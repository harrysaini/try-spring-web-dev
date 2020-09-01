package com.harry.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLogAspect {

    @Before("com.harry.springaop.aspect.PointcutsContainer.forDAOExclusive()")
    public void log() {
	System.out.println("=======> Cloud log advice");
    }
}
