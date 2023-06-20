package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberVO;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/member")
public class UserMemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm(HttpServletRequest request) {
		String url = request.getHeader("referer");
		request.setAttribute("url", url);
		return "member/login";
	}
	
	@PostMapping("/dologin")
	public String doLogin(Model model, HttpSession session, String userid, String userpwd, String url) {
		MemberVO member = memberService.selectUserid(userid);
		
		if(member == null || !(member.getUserpwd().equalsIgnoreCase(userpwd) )) {
			model.addAttribute("message","아이디 혹은 비밀번호가 틀렸습니다.");
			return "member/login";
		}
		session.setAttribute("loginUser", member.getId());
		return "redirect:"+url;
	}
	
	@GetMapping("/dologout")
	public String doLogout(HttpSession session, HttpServletRequest request) {
		String url = request.getHeader("referer");
		session.invalidate();
		return "redirect:"+url;
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	@PostMapping("/dojoin")
	public String doJoin(MemberVO memberVO) {
		int result = memberService.doJoin(memberVO);
		return "redirect:/member/login";
	}
}
