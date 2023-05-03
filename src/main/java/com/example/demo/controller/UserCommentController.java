package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class UserCommentController {

	private CommentService commentService; 
	private MemberService memberService;
	
//	@PostMapping("/dowrite")
//	public String doWrite(HttpServletRequest request,HttpSession session, CommentDTO comment) {
//		String url = request.getHeader("referer");
//		int userid =  (int) session.getAttribute("loginUser");
//		String nickname = memberService.getNickname(userid);
//		
//		comment.setUserid(userid);
//		comment.setNickname(nickname);
//		
//		commentService.doWrite(comment);
//		return "redirect:"+url;
//	}
//	
//	@PostMapping("/domodify")
//	public String doModify(HttpServletRequest request, CommentDTO comment) throws UnsupportedEncodingException {
//		commentService.doModify(comment);
//		String url = request.getHeader("referer");
//		return "redirect:"+url;
//	}
//	
//	@GetMapping("/dodelete")
//	public String doDelete(HttpServletRequest request,int id){
//		commentService.doDelete(id); 
//		String url = request.getHeader("referer");
//		return "redirect:"+url;
//	}
	
	//rest API 사용하기
	@GetMapping(
			value = "/{hpid}",
			produces = {MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<List<CommentDTO>> getComment(@PathVariable("hpid") String hpid){
		
		List<CommentDTO> list = commentService.getComments(hpid);
		ResponseEntity<List<CommentDTO>> entity = new ResponseEntity<List<CommentDTO>>(commentService.getComments(hpid), HttpStatus.OK);
		return entity; 
	}
	
	@PostMapping(
			value = "/new",
			consumes = "application/json",
			produces = {MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<CommentDTO> writeComment(@RequestBody CommentDTO commentDTO){
		
		int result = commentService.doWrite(commentDTO);
		
		ResponseEntity<CommentDTO> entity;
		
		commentDTO = commentService.getComment(commentService.getLastId());
		if(result == 1) {
			entity = new ResponseEntity<CommentDTO>(commentDTO,HttpStatus.OK);
		}else {
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
}
