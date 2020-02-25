package com.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

	@Before("com.springdemo.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void analytics() {
		System.out.println(
				"\n===============================> Logging API Analytics method call <===========================");
	}
}
