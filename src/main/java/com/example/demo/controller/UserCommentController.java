package com.example.demo.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/comm")
@AllArgsConstructor
public class UserCommentController {

	private CommentService commentService; 
	private MemberService memberService;
	
	@PostMapping("/dowrite")
	public String doWrite(HttpServletRequest request,HttpSession session, CommentDTO comment) {
		String url = request.getHeader("referer");
		int userid =  (int) session.getAttribute("loginUser");
		String nickname = memberService.getNickname(userid);
		
		comment.setUserid(userid);
		comment.setNickname(nickname);
		
		commentService.doWrite(comment);
		return "redirect:"+url;
	}
	
	@PostMapping("/domodify")
	public String doModify(HttpServletRequest request, CommentDTO comment) throws UnsupportedEncodingException {
		commentService.doModify(comment);
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
