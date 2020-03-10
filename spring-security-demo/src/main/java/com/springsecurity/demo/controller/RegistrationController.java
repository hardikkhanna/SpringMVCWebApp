package com.springsecurity.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsecurity.demo.user.CRMUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserDetailsManager userDetailsManager;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showRegisterForm(Model theModel) {

		theModel.addAttribute("crmUser", new CRMUser());

		return "registerUser"; 
	}

	@PostMapping("/processRegistrationForm")
	public String processRegisterForm(@Valid @ModelAttribute("crmUser") CRMUser theCrmUser,
			BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			theModel.addAttribute("crmUser", new CRMUser());
			theModel.addAttribute("registrationError" , "User name/Password cannot be Empty");
			return "registerUser";
		}
		
		
		String userName = theCrmUser.getUserName();
		
		boolean userExist = doesUserExist(userName);
		if(userExist) {
			theModel.addAttribute("registrationError","User already exists");
			return  "registerUser";
		}
		
		String encodedPassword = passwordEncoder.encode(theCrmUser.getPassword());
		
		List<GrantedAuthority> authorities =
				 AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		
		User tempUser = new User(userName, encodedPassword, authorities);
		
		userDetailsManager.createUser(tempUser);

		return "registration-confirmation";
	}
	
	private boolean doesUserExist(String userName) {
		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);
		return exists;
	}
}
