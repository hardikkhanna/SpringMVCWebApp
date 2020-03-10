package com.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	private static final String EMPLOYEE_ROLE = "EMPLOYEE";

	private static final String ADMIN_ROLE = "ADMIN";

	private static final String MANAGER_ROLE = "MANAGER";

	private static final String ACCESS_DENIED = "/accessdenied";

	@Autowired
	private DataSource securityDataSource;

	// To get the Security from Spring Security
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Gettinlg users from DataBase
		auth.jdbcAuthentication().dataSource(securityDataSource);

		// Hardcoding Users

		/*
		 * auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(
		 * "Hardik").password(ENCODED_PASSWORD) .roles(EMPLOYEE_ROLE);
		 * auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(
		 * "Oshin").password(ENCODED_PASSWORD) .roles(EMPLOYEE_ROLE, MANAGER_ROLE);
		 * auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(
		 * "Mohit").password(ENCODED_PASSWORD) .roles(EMPLOYEE_ROLE, ADMIN_ROLE);
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").hasRole(EMPLOYEE_ROLE).antMatchers("/leaders/**")
				.hasRole(MANAGER_ROLE).antMatchers("/systems/**").hasRole(ADMIN_ROLE).and().formLogin()
				.loginPage(LOGIN_FORM_PAGE).loginProcessingUrl(AUTHENTICATE_USER).permitAll().and().logout().permitAll()
				.and().exceptionHandling().accessDeniedPage(ACCESS_DENIED);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
