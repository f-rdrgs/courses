package com.springboot_course.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot_course.aopdemo.dao.AccountDAO;
import com.springboot_course.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccoundDAO, MembershipDAO theMembershipDAO){
		return runner -> {
			demoTheBeforeAdvice(theAccoundDAO,theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccoundDAO, MembershipDAO theMembershipDAO) {
		Account myAccount = new Account();
		theAccoundDAO.addAccount(myAccount,true);

		theAccoundDAO.doWork();

		theMembershipDAO.addSillyMember();

		theMembershipDAO.goToSleep();
	}
}
