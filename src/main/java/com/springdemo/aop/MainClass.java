package com.springdemo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aop.dao.AccountDAO;
import com.springdemo.aop.dao.MembershipDAO;

public class MainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		accountDAO.addAccount();
		
		membershipDAO.addAccount();
		
		context.close();
	}

}
