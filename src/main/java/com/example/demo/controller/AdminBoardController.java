package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import com.example.demo.dto.AdminBoardDTO;
import com.example.demo.service.AdminBoardService;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminBoardController {
	
	@Autowired
	private AdminBoardService adminBoardService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/updateForm")
	public String dbUpdate() {
		return "admin/updateForm";
	}
	
	@GetMapping("/doUpdate")
	public String hospitalList() throws SAXException, IOException, ParserConfigurationException {
		int a = adminBoardService.getHospitalList();
		return "redirect:/";
	}
	
	@PostMapping("/abWrite")
	public String adWriteAction(HttpServletRequest request, HttpSession session,String hpid, String body, String type) {
		int id = (int)session.getAttribute("loginUser");
		String writer = memberService.getNickname(id);
				
		AdminBoardDTO adminBoardDTO = new AdminBoardDTO();
		adminBoardDTO.setHpid(hpid);
		adminBoardDTO.setBody(body);
		adminBoardDTO.setWriter(writer);
		adminBoardDTO.setType(type);
		
		String url = request.getHeader("referer");
		adminBoardService.writeAction(adminBoardDTO);
		
		return "redirect:"+url;
	}
	
	@GetMapping("/boardlist")
	public String getBoardList(Model model) {
		List<AdminBoardDTO> list = adminBoardService.getBoardList();
		model.addAttribute("list",list);
		return "admin/boardlist";
	}
	
	
}
