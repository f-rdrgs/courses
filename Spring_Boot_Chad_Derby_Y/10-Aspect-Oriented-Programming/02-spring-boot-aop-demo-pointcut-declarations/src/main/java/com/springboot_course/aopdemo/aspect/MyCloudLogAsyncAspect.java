package com.springboot_course.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value=1)
public class MyCloudLogAsyncAspect {

    @Before("com.springboot_course.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n======>>> Logging to cloud in async fashion");
    }
}
