package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageCriteriaDTO {
	private int page;
	private String type;
	private String location;
	
	private String keyword;
	
//	public PageCriteriaDTO(){
//		this(1,0,"강남구","");
//	}
}
