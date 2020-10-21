package com.noobyang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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

    // 返回后通知： 执行方法结束前执行(异常不执行)
    @AfterReturning("execution(* com.noobyang.aop.*.*(..))")
    public void afterReturning() {
        System.out.println("AOP afterReturning");

    }

    // 异常通知:  出现异常时候执行
    @AfterThrowing("execution(* com.noobyang.aop.*.*(..))")
    public void afterThrowing() {
        System.out.println("AOP afterThrowing");

    }

    // 环绕通知： 环绕目标方法执行
    @Around("execution(* com.noobyang.aop.*.*(..))")
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("AOP around before");
        try {
            pjp.proceed();  // 执行目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("AOP around after");


    }

}
