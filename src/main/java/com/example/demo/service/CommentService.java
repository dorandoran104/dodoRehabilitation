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

	public void doWrite(CommentDTO comment) {
		commentRepository.insertComment(comment);
	}

	public void doModify(CommentDTO comment) {
		commentRepository.doModify(comment);
	}

	public void doDelete(int id) {
		commentRepository.doDelete(id);
	}


}
