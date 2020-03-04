package com.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showLoginPage")
	public String showMyLoginPage() {
		
		return "Login";
	}
	
	@GetMapping("/accessdenied")
	public String accessDeniedPage() {
		
		return "access-denied";
	}

}
