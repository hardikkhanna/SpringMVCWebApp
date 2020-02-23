package com.springdemo.aop.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.springdemo.aop.dao","com.springdemo.aop.main","com.springdemo.aop.aspect","com.springdemo.aop.service"})
@EnableAspectJAutoProxy
public class DemoConfig {

	
}
