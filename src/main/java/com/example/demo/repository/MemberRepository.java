package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.MemberDTO;
@Mapper
public interface MemberRepository {

	void doJoin(MemberDTO member);

	MemberDTO selectUserid(String userid);
	
	MemberDTO selectid(int id);

}
