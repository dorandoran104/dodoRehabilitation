package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO {
	private int id;
	private String nickname;
	private String userid;
	private String userpwd;
	private String phone;
	private String email;
	private String regDate;
	private boolean delMember;
	private String delDate;
	
}
