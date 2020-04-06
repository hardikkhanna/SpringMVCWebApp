package com.springmvc.demo.aop.main;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springmvc.demo.aop.service.TrafficFortuneService;
import com.springmvc.demo.aop.dao.AccountDAO;
import com.springmvc.demo.aop.dao.MembershipDAO;



public class MainClass {

	private static Logger log = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theaccount = context.getBean("accountDAO", AccountDAO.class);

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		log.info("\n Main Program : AroundDemoApp");

		log.info("Calling getFortune");
		
		boolean trip = true;

		String data = theFortuneService.getFortune(trip);

		log.info("\n My Fortune is : " + data);

		log.info("Finished");

		List<Account> theAccounts = null;
		try {
			boolean tripwire = true;

			theAccounts = theaccount.findAccounts(tripwire);
		} catch (Exception e) {
			log.info("\n Exception caught in main program : " + e);
		}

		theAccounts = theaccount.findAccounts(false);

		log.info("\n\n Main Program : AfterReturning");

		log.info("-------------");

		log.info(theAccounts.toString());

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
