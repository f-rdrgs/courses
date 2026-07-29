package com.springboot_course.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAopExpressions {

    // Declaring a pointcut expression to reuse it
    @Pointcut("execution(* com.springboot_course.aopdemo.dao.*.*(..))")
    public  void forDaoPackage() {
    }

    @Pointcut("execution(* com.springboot_course.aopdemo.dao.*.get(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.springboot_course.aopdemo.dao.*.set(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }

}
