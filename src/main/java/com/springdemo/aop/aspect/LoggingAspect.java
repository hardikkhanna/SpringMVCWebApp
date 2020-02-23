package com.springdemo.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springdemo.aop.main.Account;

@Component
@Aspect
@Order(2)
public class LoggingAspect {

	@After("execution(* com.springdemo.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n===============================> Logging @After (finally) on Method : " + method
				+ " <===========================");
	}

	@AfterThrowing(pointcut = "execution(* com.springdemo.aop.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n===============================> Logging @AfterThrowing on Method : " + method
				+ " <===========================");
		System.out.println("Exception is : " + theExc);
	}

	@AfterReturning(pointcut = "execution(* com.springdemo.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningAdivce(JoinPoint theJoinPoint, List<Account> result) {

		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n===============================> Logging @AfterReturning on Method : " + method
				+ " <===========================");
		System.out.println("Result is : " + result);
		createAccountNamesToUpperCase(result);
		System.out.println("Result is : " + result);

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

		System.out.println("Method: " + methodSig);

		Object[] args = theJoinPoint.getArgs(); // return an array of objects those are actual args

		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("Account Name : " + theAccount.getName());
				System.out.println("Account Level : " + theAccount.getLevel());

			}

		}

	}
}
