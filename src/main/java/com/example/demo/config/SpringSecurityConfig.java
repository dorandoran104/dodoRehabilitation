package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFileterChan(HttpSecurity http) throws Exception{
		return http
				//Http 요청에 대해 권한 설정
				.authorizeRequests()
					.antMatchers("/bboard/**").authenticated()
				//어느 URL로 접근해도 인증이 필요하게
//				.anyRequest().authenticated()
				.and()
				//로그인 폼
				.formLogin()
					.loginPage("/member/login")
					.defaultSuccessUrl("/")
					.permitAll()
				.and()
					.logout()
				.and()
				.build();			
	}
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
