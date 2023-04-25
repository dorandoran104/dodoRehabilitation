package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberService {

	private MemberRepository memberRepository;
	
	MemberService(MemberRepository memberRepository){
		this.memberRepository = memberRepository;
	}
	public void doJoin(String nickname, String userid, String userpwd, String phone, String email) {
		MemberDTO member = new MemberDTO();
		member.setNickname(nickname);
		member.setUserid(userid);
		member.setUserpwd(userpwd);
		member.setPhone(phone);
		member.setEmail(email);
		memberRepository.doJoin(member);
	}
	public MemberDTO selectUserid(String userid) {
		MemberDTO member = memberRepository.selectUserid(userid);
		return member;
	}
	
	public String getNickname(int id) {
		MemberDTO member = memberRepository.selectid(id);
		return member.getNickname();
	}

}
