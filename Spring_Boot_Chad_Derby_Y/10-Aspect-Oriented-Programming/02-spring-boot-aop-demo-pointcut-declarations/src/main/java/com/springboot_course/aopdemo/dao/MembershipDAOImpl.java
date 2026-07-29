package com.springboot_course.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addSillyMember() {
        System.out.println(getClass() + ": Doing my DB WORK : Adding a membership account");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+": I'm going to sleep now...");
    }
    
}
