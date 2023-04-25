package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.CommentService;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/comm")
public class UserCommentController {

	@Autowired
	private CommentService commentService;
	@Autowired 
	private MemberService memberService;
	
	@PostMapping("/dowrite")
	public String doWrite(HttpServletRequest request,HttpSession session, String body, String hpid) {
		String url = request.getHeader("referer");
		int id =  (int) session.getAttribute("loginUser");
		String nickname = memberService.getNickname(id);
		commentService.doWrite(hpid,body,nickname,id);
		return "redirect:"+url;
	}
	
	@PostMapping("/domodify")
	public String doModify(HttpServletRequest request,int id, String body) throws UnsupportedEncodingException {
		commentService.doModify(id, body);
		String url = request.getHeader("referer");
		return "redirect:"+url;
	}
	
	@GetMapping("/dodelete")
	public String doDelete(HttpServletRequest request,int id){
		commentService.doDelete(id); 
		String url = request.getHeader("referer");
		return "redirect:"+url;
	}
}
