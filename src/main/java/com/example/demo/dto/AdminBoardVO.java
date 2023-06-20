package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AdminBoardVO {
	private int id;
	private String dutyname;
	private String body;
	private String type;
	private String hpid;
	private String writer;
	private Date regDate;
}
