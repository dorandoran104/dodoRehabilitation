package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value= {"com.example.demo.repository"})
@SpringBootApplication
public class DoRehabilitationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoRehabilitationApplication.class, args);
	}

}
