package com.springdemo.aop.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aop.dao.AccountDAO;
import com.springdemo.aop.dao.MembershipDAO;

public class MainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theaccount = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = null;
		try {
			boolean tripwire = true;

			theAccounts = theaccount.findAccounts(tripwire);
		} catch (Exception e) {
			System.out.println("\n Exception caught in main program : " + e);
		}

		theAccounts = theaccount.findAccounts(false);

		System.out.println("\n\n Main Program : AfterReturning");

		System.out.println("-------------");

		System.out.println(theAccounts);

		MembershipDAO theMember = context.getBean("membershipDAO", MembershipDAO.class);

		Account myAccount = new Account();
		myAccount.setLevel("Gold");
		myAccount.setName("Hardik");

		theaccount.addAccount(myAccount, true);

		theaccount.doWork();

		theaccount.setServiceCode("Silver");

		theaccount.setAccountName("Sample");

		theMember.addAccount();

		theMember.goToSleep();

		context.close();
	}

}
