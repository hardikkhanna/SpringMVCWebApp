package com.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	
	@Pointcut("execution(* com.springdemo.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.springdemo.aop.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.springdemo.aop.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	//@Pointcut("execution(* com.springdemo.aop")

	// @Before("execution(* com.springdemo.aop.dao.AccountDAO.*(..)) || execution(* com.springdemo.aop.dao.MembershipDAO.*(..))")
	// @Before("execution(* com.springdemo.aop.dao.*.addAccount())")
	// @Before("execution(void com.springdemo.aop.dao.*.add*())")
	// @Before("execution(*
	// com.springdemo.aop.dao.*.addAccount(com.springdemo.aop.Account))")
	//@Before("execution(public void addAccount())")
	//@Before("execution(* com.springdemo.aop.dao.*.add*(*))")
	//@Before("execution(* com.springdemo.aop.dao.*.add*(com.springdemo.aop.main.Account,*))")
	//@Before("execution(* add*(..))")
	//@Before("execution(* com.springdemo.aop.dao.*.*(..))")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeLog() {
		System.out.println("\n===============================> Logging @Before method call <===========================");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void analytics() {
		System.out.println("\n===============================> Logging API Analytics method call <===========================");
	}
}
