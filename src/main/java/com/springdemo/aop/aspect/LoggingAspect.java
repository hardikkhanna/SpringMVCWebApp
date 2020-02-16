package com.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	// @Before("execution(* com.springdemo.aop.dao.AccountDAO.*(..)) || execution(* com.springdemo.aop.dao.MembershipDAO.*(..))")
	// @Before("execution(* com.springdemo.aop.dao.*.addAccount())")
	// @Before("execution(void com.springdemo.aop.dao.*.add*())")
	// @Before("execution(*
	// com.springdemo.aop.dao.*.addAccount(com.springdemo.aop.Account))")
	//@Before("execution(public void addAccount())")
	@Before("execution(* com.springdemo.aop.dao.AccountDAO.add*())")
	public void beforeLog() {
		System.out.println("===============================> Logging @Before method call <===========================");
	}

}
