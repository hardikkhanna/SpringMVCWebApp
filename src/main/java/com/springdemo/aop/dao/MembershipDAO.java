package com.springdemo.aop.dao;

public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": Adding a Membership Account");
	}
}
