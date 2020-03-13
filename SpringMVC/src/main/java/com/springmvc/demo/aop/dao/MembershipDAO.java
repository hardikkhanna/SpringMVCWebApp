package com.springmvc.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": Adding Membership Account");
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": I am going to Sleep now.....");
	}
	
}
