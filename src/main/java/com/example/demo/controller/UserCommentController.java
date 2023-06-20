package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	//rest API 사용하기
	@GetMapping(
			value = "/{hpid}",
			produces = {MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<List<CommentDTO>> getComment(@PathVariable("hpid") String hpid){
		
		List<CommentDTO> list = commentService.getComments(hpid);
		
		return new ResponseEntity<>(list, HttpStatus.OK); 
	}
	
	@PostMapping(
			value = "/new",
			consumes = "application/json"
			)
	public ResponseEntity<String> writeComment(@RequestBody CommentDTO commentDTO){
		
		int result = commentService.doWrite(commentDTO);
		System.out.println("comment : " + commentDTO);
		System.out.println("result : " + result);
		return result > 0 ? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") int id){
		
		int result = commentService.deleteComment(id);
		System.out.println(id);
		return result>0 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<String> modifyComment(@PathVariable("id") int id,@RequestBody String body){
		System.out.println(body);
		int result = commentService.modifyComment(id,body);
		
		return result > 0 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
