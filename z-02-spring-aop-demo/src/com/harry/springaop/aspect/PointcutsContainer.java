package com.harry.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutsContainer {
    @Pointcut("execution(public * com.harry.springaop.dao.*.*(..))")
    public void forDAO() {
    }

    @Pointcut("execution(public * com.harry.springaop.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(public * com.harry.springaop.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDAO() && !(getter() || setter())")
    public void forDAOExclusive() {
    }
}
