package com.springdemo.aop.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.springdemo.aop.dao","com.springdemo.aop.main","com.springdemo.aop.aspect"})
@EnableAspectJAutoProxy
public class DemoConfig {

	
}
