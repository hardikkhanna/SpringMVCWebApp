package com.springdemo.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springdemo.aop.main.Account;

@Component
@Aspect
@Order(2)
public class LoggingAspect {

	private static Logger log = Logger.getLogger(LoggingAspect.class.getName());

	@Around("execution(* com.springdemo.aop.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theJoinPoint) throws Throwable {

		String method = theJoinPoint.getSignature().toShortString();
		log.info("\n===============================> Logging @Around on Method : " + method
				+ " <===========================");
		long begin = System.currentTimeMillis();

		Object result = null;

		try {
			result = theJoinPoint.proceed();
		} catch (Exception e) {

			log.warning(e.getMessage());
			//To handle the Exception Uncomment the below line
			result = "Handled Exception in @Around Advice ";
			//throw e;
		}

		long end = System.currentTimeMillis();

		long duration = end - begin;

		log.info("\n=======> Duration : " + duration / 1000.0 + " seconds");

		return result;

	}

	@After("execution(* com.springdemo.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		log.info("\n===============================> Logging @After (finally) on Method : " + method
				+ " <===========================");
	}

	@AfterThrowing(pointcut = "execution(* com.springdemo.aop.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		log.info("\n===============================> Logging @AfterThrowing on Method : " + method
				+ " <===========================");
		log.info("Exception is : " + theExc);
	}

	@AfterReturning(pointcut = "execution(* com.springdemo.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningAdivce(JoinPoint theJoinPoint, List<Account> result) {

		String method = theJoinPoint.getSignature().toShortString();
		log.info("\n===============================> Logging @AfterReturning on Method : " + method
				+ " <===========================");
		log.info("Result is : " + result);
		createAccountNamesToUpperCase(result);
		log.info("Result is : " + result);

	}

	private void createAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		for (Account temp : result) {
			// get uppercase version of account name
			String theAccountName = temp.getName().toUpperCase();
			// update name of the account object
			temp.setName(theAccountName);

		}

	}

	@Before("com.springdemo.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		System.out
				.println("\n===============================> Logging @Before method call <===========================");

		// display the method signature
		Signature methodSig = theJoinPoint.getSignature();

		log.info("Method: " + methodSig);

		Object[] args = theJoinPoint.getArgs(); // return an array of objects those are actual args

		for (Object tempArg : args) {
			log.info(tempArg.toString());

			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				log.info("Account Name : " + theAccount.getName());
				log.info("Account Level : " + theAccount.getLevel());

			}

		}

	}
}
