package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CommentVO;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	
	CommentService(CommentRepository commentRepository){
		this.commentRepository = commentRepository;
	}

	public List<CommentVO> getComments(String hpid) {
		List<CommentVO> list = commentRepository.getComments(hpid);
		return list;
	}

	public int doWrite(CommentVO comment) {
		int result = commentRepository.insertComment(comment);
		
		return result;
	}

	public int getLastId() {
		int result = commentRepository.getLastId();
		return result;
	}

	public CommentVO getComment(int lastId) {
		CommentVO commentDTO = commentRepository.getComment(lastId);
		return commentDTO;
	}

	public int deleteComment(int id) {
		return commentRepository.deleteComment(id);
	}

	public int modifyComment(int id, String body) {
		CommentVO commentDTO = new CommentVO();
		commentDTO.setId(id);
		commentDTO.setBody(body);
		return commentRepository.modifyComment(commentDTO);
	}
	
}
