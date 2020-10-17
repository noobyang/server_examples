package com.noobyang.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOP {

    @Before("execution(* com.noobyang.aop.*.*(..))")
    public void before() {
        System.out.println("AOP before");

    }

    @After("execution(* com.noobyang.aop.*.*(..))")
    public void after() {
        System.out.println("AOP after");

    }

}
