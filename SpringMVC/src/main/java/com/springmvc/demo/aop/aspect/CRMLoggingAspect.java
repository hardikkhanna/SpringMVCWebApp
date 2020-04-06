package com.springmvc.demo.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// Setup Logger
	private Logger log = Logger.getLogger(getClass().getName());

	// Setup POintcut Declaration
	@Pointcut("execution(* com.springmvc.demo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.springmvc.demo.services.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.springmvc.demo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before Advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display the method that is being called
		String method = theJoinPoint.getSignature().toShortString();
		log.info("\n ================>	in @Before calling Mehtod : " + method);

		// display the method parameters that are being called

		Object[] args = theJoinPoint.getArgs();
		for (Object tempArgs : args) {
			log.info("\n ============> arguements : " + tempArgs);
		}

	}

	// add @AfterReturning Advice
	@AfterReturning(pointcut = "forAppFlow()", returning ="result")
	public void afterReturning(JoinPoint theJoinPoint , Object result)  {
		
		// Display the method we are returning from
		String method = theJoinPoint.getSignature().toShortString();
		log.info("\n ===========> in @AfterReturning from method : " + method);
	
		log.info("======> Result is :  " + result);
		//Loop through Display args
		
		
	}

}
