package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.HospitalDTO;
import com.example.demo.dto.PageCriteriaDTO;

import lombok.Setter;

public class TestRepository {
	
	@Autowired
	public HospitalRepository mapper;
	
	@Test
	public void test() {
		PageCriteriaDTO cri = new PageCriteriaDTO();
		
		List<HospitalDTO> list = mapper.getKeyWoardList(cri);
		
		System.out.println(list);
		
	}
}
