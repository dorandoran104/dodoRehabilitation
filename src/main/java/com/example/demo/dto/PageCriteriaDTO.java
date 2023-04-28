package com.example.demo.dto;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PageCriteriaDTO {
	private int page;
	private String type;
	private String location;
	
	private String keyword;
	
//	public PageCriteriaDTO(){
//		this(1,0,"강남구","");
//	}
	public PageCriteriaDTO() {
		this.page = 1;
	}
	
	public String uriLink() {
		UriComponentsBuilder url = UriComponentsBuilder.fromPath("")
				.queryParam("page", page)
				.queryParam("type", type)
				.queryParam("location", location)
				.queryParam("keyword", keyword);
		return url.toUriString();
	}
}
