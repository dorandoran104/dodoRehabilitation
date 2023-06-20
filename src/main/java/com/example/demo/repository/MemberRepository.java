package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.AuthVO;
import com.example.demo.dto.MemberVO;
@Mapper
public interface MemberRepository {

	void doJoin(MemberVO member);

	MemberVO selectUserid(String userid);
	
	MemberVO selectid(int id);

	int insertAuth(AuthVO authVO);

}
