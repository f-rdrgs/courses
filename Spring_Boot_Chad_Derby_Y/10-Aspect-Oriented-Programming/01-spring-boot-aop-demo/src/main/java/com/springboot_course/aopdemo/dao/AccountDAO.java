package com.springboot_course.aopdemo.dao;

import com.springboot_course.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
