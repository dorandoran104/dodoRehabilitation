package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AuthVO;
import com.example.demo.dto.MemberVO;
import com.example.demo.repository.MemberRepository;

import lombok.Setter;

@Service
public class MemberService {
	
	private BCryptPasswordEncoder encoder;
	
	private MemberRepository memberRepository;
	
	MemberService(MemberRepository memberRepository, BCryptPasswordEncoder encoder){
		this.memberRepository = memberRepository;
		this.encoder = encoder;
	}
	
	@Transactional
	public int doJoin(MemberVO memberVO) {
		memberVO.setUserpwd(encoder.encode(memberVO.getUserpwd()));
		memberRepository.doJoin(memberVO);
		
		AuthVO authVO = new AuthVO();
		
		authVO.setAuth("ROLE_MEMBER");
		authVO.setMemberNo(memberVO.getId());
		
		return memberRepository.insertAuth(authVO);
	}
	
	public MemberVO selectUserid(String userid) {
		MemberVO member = memberRepository.selectUserid(userid);
		return member;
	}
	
	public String getNickname(int id) {
		MemberVO member = memberRepository.selectid(id);
		return member.getNickname();
	}

}
