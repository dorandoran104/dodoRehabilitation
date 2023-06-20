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
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import com.example.demo.dto.AdminBoardVO;
import com.example.demo.dto.PageCriteriaDTO;
import com.example.demo.service.AdminBoardService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin")
public class AdminBoardController {
	private AdminBoardService adminBoardService;
	private MemberService memberService;
	
	public AdminBoardController(AdminBoardService adminBoardService, MemberService memberService) {
		this.adminBoardService  = adminBoardService;
		this.memberService = memberService;
	}
	
	
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
	public String adWriteAction(HttpSession session,String hpid, String body,@RequestParam("type_info") String type,PageCriteriaDTO cri) {
		int id = (int)session.getAttribute("loginUser");
		String writer = memberService.getNickname(id);
		AdminBoardVO adminBoardDTO = new AdminBoardVO();
		
		adminBoardDTO.setWriter(writer);
		adminBoardDTO.setBody(body);
		adminBoardDTO.setHpid(hpid);
		adminBoardDTO.setType(type);
		
		adminBoardService.writeAction(adminBoardDTO);
		String uri = cri.uriLink() + "&hpid="+adminBoardDTO.getHpid();
		return "redirect:/hospi/gethospital"+ uri;
	}
	
	@GetMapping("/boardlist")
	public String getBoardList(Model model) {
		List<AdminBoardVO> list = adminBoardService.getBoardList();
		model.addAttribute("list",list);
		return "admin/boardlist";
	}
	
	
}
