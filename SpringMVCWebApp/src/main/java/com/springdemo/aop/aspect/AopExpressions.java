package com.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {
	@Pointcut("execution(* com.springdemo.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.springdemo.aop.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.springdemo.aop.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}

	// @Pointcut("execution(* com.springdemo.aop")

	// @Before("execution(* com.springdemo.aop.dao.AccountDAO.*(..)) || execution(*
	// com.springdemo.aop.dao.MembershipDAO.*(..))")
	// @Before("execution(* com.springdemo.aop.dao.*.addAccount())")
	// @Before("execution(void com.springdemo.aop.dao.*.add*())")
	// @Before("execution(*
	// com.springdemo.aop.dao.*.addAccount(com.springdemo.aop.Account))")
	// @Before("execution(public void addAccount())")
	// @Before("execution(* com.springdemo.aop.dao.*.add*(*))")
	// @Before("execution(*
	// com.springdemo.aop.dao.*.add*(com.springdemo.aop.main.Account,*))")
	// @Before("execution(* add*(..))")
	// @Before("execution(* com.springdemo.aop.dao.*.*(..))")
}
