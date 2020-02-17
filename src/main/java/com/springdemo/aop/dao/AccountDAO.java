package com.springdemo.aop.dao;

import org.springframework.stereotype.Component;

import com.springdemo.aop.main.Account;

@Component
public class AccountDAO {
	
	
	private String accountName;
	private String serviceCode;

	public String getAccountName() {
		System.out.println(getClass() + ": In getAccountName()");
		return accountName;
	}

	public void setAccountName(String accountName) {
		System.out.println(getClass() + ": In setAccountName()");
		this.accountName = accountName;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": In getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": In setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + ": Adding an Account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

}
