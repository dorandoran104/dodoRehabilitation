package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
	private int id;
	private int userid;
	private String hpid;
	private String body;
	private String writeDate;
	private String updateDate;
	private String nickname;
}
