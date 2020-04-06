package com.springmvc.demo.aop.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.springmvc.demo.aop.dao","com.springmvc.demo.aop.main","com.springmvc.demo.aop.aspect","com.springmvc.demo.aop.service"})
@EnableAspectJAutoProxy
public class DemoConfig {

	
}
