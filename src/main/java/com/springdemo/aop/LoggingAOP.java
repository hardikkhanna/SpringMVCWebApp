package com.springdemo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class LoggingAOP {

	//@Before("execution(* com.springdemo.aop.dao.AccountDAO.*(..)) || execution(* com.springdemo.aop.dao.MembershipDAO.*(..))")
	//@Before("execution(* com.springdemo.aop.dao.*.addAccount())")
	@Before("execution(void com.springdemo.aop.dao.*.add*())")
	public void beforeLog() {
		System.out.println("\n============================> Logging Before Method Call <===========================");
	}

	@After("execution(* com.springdemo.aop.dao.*.add*())")
	public void afterLog() {
		System.out.println("\n============================> Logging After Method Call <===========================");
	}

}
