package com.springdemo.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.springdemo.aop.dao.AccountDAO;
import com.springdemo.aop.dao.MembershipDAO;

import sun.rmi.runtime.NewThreadAction;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({ "com.springdemo.aop.dao", "com.springdemo.aop", "com.springdemo.aop.aspect" })

public class Config {

	@Bean
	public AccountDAO accountDAO() {
		return new AccountDAO();
	}
	
	@Bean
	public MembershipDAO membershipDAO() {
		return new MembershipDAO();
	}
	
	@Bean
	public LoggingAOP logging() {
		return new LoggingAOP(); 
	}
	
}
