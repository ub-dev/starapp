package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.service.MyUserDetailService;

//import com.star.login.MyUserDetailService;

@EnableWebSecurity // represents this as a configuration class
public class AuthenticationAndAuthorizationConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailService myUserDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(myUserDetailService);
		// System.out.println(myUserDetailService.loadUserByUsername("new").getUsername());
		// System.out.println(getPasswordEncoder().encode("abc"));
		// System.out.println(getPasswordEncoder().encode("hello"));
		// System.out.println(myUserDetailService.loadUserByUsername("new").getPassword());
		// System.out.println(myUserDetailService.loadUserByUsername("ub").getUsername());

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests().anyRequest().authenticated().and().formLogin();

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() { // just for testing
		return new BCryptPasswordEncoder(); // will return the password in clear text
		// to get rid of no PasswordEncoderMapped Exception(IllegalArgumentException)
	}

}
