package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;

public class TestRepository {
	
	@Setter(onMethod_=@Autowired)
	public CommentRepository commentRepository;
	
	@Test
	public void test() {
		
	}
}
