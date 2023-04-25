package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BugBoardDTO {
	private int id;
	private String title;
	private String body;
	private String nickname;
	private int userNum;
	private Date regDate;
	private Date updateDate;
	private int secret;
}
