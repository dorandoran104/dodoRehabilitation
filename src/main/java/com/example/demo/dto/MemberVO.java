package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberVO {
	private String nickname;
	private String userid;
	private String userpwd;
	private String phone;
	private String email;
	private String regDate;
	private boolean delMember;
	private String delDate;
	
	private List<AuthVO> authList;
	
}
