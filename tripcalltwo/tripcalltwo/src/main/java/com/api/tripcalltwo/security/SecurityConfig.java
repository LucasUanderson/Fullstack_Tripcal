package com.api.tripcalltwo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	@Bean 
	public SecurityFilterChain filterChain (HttpSecurity httpSec) throws Exception {
		httpSec
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.GET, "/usuario").permitAll()
		.anyRequest().authenticated().and().cors();
		httpSec.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
		return httpSec.build();
		
		
		
	}

}
