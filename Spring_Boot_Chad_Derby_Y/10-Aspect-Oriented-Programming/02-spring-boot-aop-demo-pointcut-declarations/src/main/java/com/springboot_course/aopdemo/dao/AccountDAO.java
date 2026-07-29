package com.springboot_course.aopdemo.dao;

import java.util.List;

import com.springboot_course.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

        public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    public List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
