package com.springboot_course.aopdemo.aspect;

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

import com.springboot_course.aopdemo.Account;

@Aspect
@Component
@Order(value = 2)
public class MyDemoLoggingAspect {

    // In the parenthesis is a pointcut expression that calls ANY method called addAccount, no matter the class as it is not specified
    //   @Before("execution(* add*(com.springboot_course.aopdemo.Account, boolean))") works as well. Here we match in an absolute manner that we have an Account and then any number of parameter
    @Before("com.springboot_course.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n======>>> Executing @Before advice on addAccount()");

        // Displaying method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // Display method arguments
        Object[] args = theJoinPoint.getArgs();

        // loop through the args
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;

                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.springboot_course.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>> Result is: " + result);

        convertAccountnameToUpperCase(result);
        System.out.println("\n=====>>> Post-processed result is: " + result);
    }

    private void convertAccountnameToUpperCase(List<Account> result) {
        for (Account tempAccount : result) {
            // We are able to modify the accounts without returning since the list contains references obviously, not objects.
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.springboot_course.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc
    ) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n=====>>> The exception is: " + theExc);
    }

    @After("execution(* com.springboot_course.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);

    }

    @Around("execution(* com.springboot_course.aopdemo.service.*.getFortune(..))")
    public Object aroundGetfortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // long begin = System.currentTimeMillis();
        long begin = System.nanoTime();
        // Execute method
        Object result = null;
// Execute method
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception exc) {
            System.out.println("@Around advice: We have a problem " + exc);
            result = "Nothing exciting here. Move along!";

            // Throw back exception
            // throw exc;
        }
        // long end = System.currentTimeMillis();
        long end = System.nanoTime();

        long duration = end - begin;
        System.out.println("\n=====> Duration: " + duration + " nanoseconds");
        return result;

    }
}
