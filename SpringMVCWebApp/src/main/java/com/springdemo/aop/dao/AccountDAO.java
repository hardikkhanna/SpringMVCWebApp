package com.springdemo.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springdemo.aop.main.Account;

@Component
public class AccountDAO {

	private String accountName;
	private String serviceCode;

	public List<Account> findAccounts(boolean tripwire) {
		if (tripwire) {
			throw new RuntimeException("Exception called !");
		}
		List<Account> myAccounts = new ArrayList<>();
		Account temp1 = new Account("Oshin", "Platinum");
		Account temp2 = new Account("Rakha", "Silver");
		Account temp3 = new Account("Raheja", "Bronze");

		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		return myAccounts;

	}

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
