package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {
	
	private int id;
	private String userid;
	private String hpid;
	private String body;
	private String writeDate;
	private String updateDate;
	private String nickname;
}
