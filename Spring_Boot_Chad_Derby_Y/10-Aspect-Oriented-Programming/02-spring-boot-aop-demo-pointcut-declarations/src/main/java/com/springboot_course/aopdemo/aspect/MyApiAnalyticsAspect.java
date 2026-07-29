package com.springboot_course.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value=3)
public class MyApiAnalyticsAspect {


    @Before("com.springboot_course.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n======>>> Performing API analytics");
    }
}
