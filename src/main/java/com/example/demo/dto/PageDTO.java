package com.example.demo.dto;

import lombok.Data;

//pagenation 자바객체로 받아와서 코드 깔끔하게
@Data
public class PageDTO {
	
	private int startPage;
	private int endPage;
	
	private int total;
	private PageCriteriaDTO cri;
	
	public PageDTO(PageCriteriaDTO cri, int total){
		this.total = total;
		this.cri = cri;
		
		
		this.endPage =  (int)Math.ceil(cri.getPage()/5.0)*5;
		this.startPage =  endPage-4;;

		if(Math.floor(total/15)+1 <= endPage) {
			this.endPage = (int)Math.floor(total/15)+1;
		}
	}
}
