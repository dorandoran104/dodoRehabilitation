package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {

	
	@GetMapping("/")
	public String redirectMain() {
		return "redirect:/user/home";
	}
	@GetMapping("/user/home")
	public String mainPage() {
		return "home/index";
	}
}
