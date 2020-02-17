package com.springdemo.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aop.dao.AccountDAO;
import com.springdemo.aop.dao.MembershipDAO;

public class MainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theaccount = context.getBean("accountDAO", AccountDAO.class);

		MembershipDAO theMember = context.getBean("membershipDAO", MembershipDAO.class);

		theaccount.addAccount(new Account(), true);
		
		theaccount.doWork();
		
		theaccount.setServiceCode("Silver");
		
		theaccount.setAccountName("Sample");
		
		String name = theaccount.getAccountName();
		String serviceName = theaccount.getServiceCode();

		theMember.addAccount();
		
		theMember.goToSleep();

		context.close();
	}

}
