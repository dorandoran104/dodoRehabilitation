package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageCriteriaDTO {
	private int page;
	private int type;
	private String location;
	
	public PageCriteriaDTO(){
		this(1,0,"강남구");
	}
}
