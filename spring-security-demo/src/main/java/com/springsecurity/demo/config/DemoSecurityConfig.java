package com.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.springsecurity.demo")
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String ENCODED_PASSWORD = "$2y$12$1KBBVvvUu2x.vis5GhFNluWK.vhlbcD4IZhDsm.nstV1dDuCbCqeO";

	private static final String LOGIN_FORM_PAGE = "/showLoginPage";

	private static final String AUTHENTICATE_USER = "/authenticateTheUser";

	// To get the Security from Spring Security
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("Hardik").password(ENCODED_PASSWORD)
				.roles("EMPLOYEE");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("Oshin").password(ENCODED_PASSWORD)
				.roles("ADMIN");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("Mohit").password(ENCODED_PASSWORD)
				.roles("MANAGER");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage(LOGIN_FORM_PAGE)
				.loginProcessingUrl(AUTHENTICATE_USER).permitAll().and().logout().permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
