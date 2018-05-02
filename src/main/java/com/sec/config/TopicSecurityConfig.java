package com.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sec.service.Impl.UserDetailsServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class TopicSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private TopicAuthenticationEntryPoint topicAuthenticationEntryPoint;
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		    .authorizeRequests()
		    .antMatchers("user/**").hasAnyRole("ADMIN","USER")
		    .and().httpBasic().realmName("Topic Security Application Realm")
		    .authenticationEntryPoint(topicAuthenticationEntryPoint);
		
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		BCryptPasswordEncoder bCryptPasswordEncoder = new  BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
		
	}
	
	
	
	
	

}
