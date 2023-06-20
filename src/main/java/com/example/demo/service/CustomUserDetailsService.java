package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.dto.CustomUser;
import com.example.demo.dto.MemberVO;
import com.example.demo.repository.MemberRepository;

import lombok.Setter;

public class CustomUserDetailsService implements UserDetailsService{

	@Setter(onMethod_=@Autowired)
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO memberVO = memberRepository.selectUserid(username);
		System.out.println(memberVO);
		return memberVO == null ? null : new CustomUser(memberVO);
	}

}
