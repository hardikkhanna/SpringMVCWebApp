package com.springdemo.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aop.dao.AccountDAO;
import com.springdemo.aop.dao.MembershipDAO;

public class MainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theaccount = context.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO theMember = context.getBean("membershipDAO",MembershipDAO.class);
		
		theaccount.addAccount();
		
		theMember.addAccount();
		
		context.close();
	}

}
