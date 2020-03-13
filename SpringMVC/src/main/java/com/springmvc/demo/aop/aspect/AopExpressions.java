package com.springmvc.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {
	@Pointcut("execution(* com.springmvc.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.springmvc.aop.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.springmvc.aop.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}

	// @Pointcut("execution(* com.springmvc.aop")

	// @Before("execution(* com.springmvc.aop.dao.AccountDAO.*(..)) || execution(*
	// com.springmvc.aop.dao.MembershipDAO.*(..))")
	// @Before("execution(* com.springmvc.aop.dao.*.addAccount())")
	// @Before("execution(void com.springmvc.aop.dao.*.add*())")
	// @Before("execution(*
	// com.springmvc.aop.dao.*.addAccount(com.springmvc.aop.Account))")
	// @Before("execution(public void addAccount())")
	// @Before("execution(* com.springmvc.aop.dao.*.add*(*))")
	// @Before("execution(*
	// com.springmvc.aop.dao.*.add*(com.springmvc.aop.main.Account,*))")
	// @Before("execution(* add*(..))")
	// @Before("execution(* com.springmvc.aop.dao.*.*(..))")
}
