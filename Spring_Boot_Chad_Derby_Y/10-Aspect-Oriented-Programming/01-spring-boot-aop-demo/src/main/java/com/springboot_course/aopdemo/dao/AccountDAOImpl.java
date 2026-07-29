package com.springboot_course.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.springboot_course.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB WORK : Adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

}
