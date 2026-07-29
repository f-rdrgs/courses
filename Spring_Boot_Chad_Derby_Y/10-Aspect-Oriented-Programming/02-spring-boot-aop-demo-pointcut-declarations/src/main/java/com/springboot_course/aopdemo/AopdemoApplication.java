package com.springboot_course.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot_course.aopdemo.dao.AccountDAO;
import com.springboot_course.aopdemo.dao.MembershipDAO;
import com.springboot_course.aopdemo.service.TrafficFortuneService;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {
        return runner -> {
            // demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
            // demoTheAfterReturningAdvice(theAccountDAO);
            // demoTheAfterThrowingAdvice(theAccountDAO);
            // demoTheAfterAdvice(theAccountDAO);
            // demoTheAroundAdvice(theTrafficFortuneService);
            demotheAroundAdviceHandleException(theTrafficFortuneService);
        };
    }

    private void demotheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\n Main Program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

		boolean tripWire = true;

        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\n Main Program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

        String data = theTrafficFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");

    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;

        try {
            // Modify here to test thrown exception case
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain program: ... caught exception: " + exc);
        }

        System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
        System.out.println("----");
        System.out.println(theAccounts);
        System.out.println("----");
        System.out.println("\n");

    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;

        try {
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\n\nMain program: ... caught exception: " + exc);
        }

        System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
        System.out.println("----");
        System.out.println(theAccounts);
        System.out.println("----");
        System.out.println("\n");

    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccoundDAO) {
        List<Account> theAccounts = theAccoundDAO.findAccounts();

        System.out.println("\n\nMain program: demoTheAfterReturningAdvice");
        System.out.println("----");
        System.out.println(theAccounts);
        System.out.println("----");
        System.out.println("\n");

    }

    private void demoTheBeforeAdvice(AccountDAO theAccoundDAO, MembershipDAO theMembershipDAO) {
        Account myAccount = new Account();
        myAccount.setName("Gordon");
        myAccount.setLevel("Platinum");
        theAccoundDAO.addAccount(myAccount, true);

        theAccoundDAO.doWork();

        // calling getter setters$
        theAccoundDAO.setName("Testing");

        theAccoundDAO.setServiceCode("silver");

        String name = theAccoundDAO.getName();
        String serviceCode = theAccoundDAO.getServiceCode();

        theMembershipDAO.addSillyMember();

        theMembershipDAO.goToSleep();
    }
}
