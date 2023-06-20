package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	
	CommentService(CommentRepository commentRepository){
		this.commentRepository = commentRepository;
	}

	public List<CommentDTO> getComments(String hpid) {
		List<CommentDTO> list = commentRepository.getComments(hpid);
		return list;
	}

	public int doWrite(CommentDTO comment) {
		int result = commentRepository.insertComment(comment);
		
		return result;
	}

	public int getLastId() {
		int result = commentRepository.getLastId();
		return result;
	}

	public CommentDTO getComment(int lastId) {
		CommentDTO commentDTO = commentRepository.getComment(lastId);
		return commentDTO;
	}

	public int deleteComment(int id) {
		return commentRepository.deleteComment(id);
	}

	public int modifyComment(int id, String body) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(id);
		commentDTO.setBody(body);
		return commentRepository.modifyComment(commentDTO);
	}
	
}
