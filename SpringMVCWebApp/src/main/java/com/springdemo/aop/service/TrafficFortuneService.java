package com.springdemo.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Expect heavy traffic this morning";
	}

	public String getFortune(boolean trip) {
		if(trip) {
			throw new RuntimeException("Major Exception !");
		}
		return getFortune();
	}

	

}
