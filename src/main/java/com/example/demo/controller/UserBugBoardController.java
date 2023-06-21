package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BugBoardDTO;
import com.example.demo.service.BugBoardService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/bboard")
@AllArgsConstructor
public class UserBugBoardController {

	private BugBoardService bugboardService;
	private MemberService memberService;
	
	@GetMapping("/getlist")
	@PreAuthorize("isAuthenticated()")
	public String getList(Model model) {
		List<BugBoardDTO> list = bugboardService.getList();
		model.addAttribute("list",list);
		return "bugboard/getlist";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "bugboard/bwriteForm";
	}
	
	@PostMapping("/writeAction")
	public String writeAction(int userNum, String title, String body, int secret) {
		String nickname = memberService.getNickname(userNum);
		bugboardService.writeBboard(userNum,nickname, title, body, secret);
		int lastId = bugboardService.getLastId();
		return "redirect:/bboard/getlist";
	}
	
	@GetMapping("/getboard")
	public String getBoard(Model model, int id) {
		BugBoardDTO bugBoardDTO = bugboardService.getBoard(id);
		model.addAttribute("board",bugBoardDTO);
		return "bugboard/getboard";
	}
	
	@GetMapping("/modifyForm")
	public String modifyForm(Model model, int id) {
		BugBoardDTO bugBoardDTO = bugboardService.getBoard(id);
		model.addAttribute("board",bugBoardDTO);
		return "bugboard/modifyForm";
	}
	
	@PostMapping("/modifyAction")
	public String modifyAction(int id, String title, String body, int secret) {
		bugboardService.modifyBoard(id, title, body, secret);
		return "redirect:/bboard/getboard?id="+id;
	}
	
	@GetMapping("/deleteAction")
	public String deleteAction(int id) {
		bugboardService.deleteBoard(id);
		return "redirect:/bboard/getlist";
	}
	
}
