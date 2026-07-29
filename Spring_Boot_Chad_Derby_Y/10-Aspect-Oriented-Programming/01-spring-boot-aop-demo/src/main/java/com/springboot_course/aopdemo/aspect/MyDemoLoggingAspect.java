package com.springboot_course.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // In the parenthesis is a pointcut expression that calls ANY method called addAccount, no matter the class as it is not specified

    //   @Before("execution(* add*(com.springboot_course.aopdemo.Account, boolean))") works as well. Here we match in an absolute manner that we have an Account and then any number of parameter
    @Before("execution(* com.springboot_course.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }
}
