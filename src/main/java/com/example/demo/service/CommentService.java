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

	public void doWrite(String hpid, String body, String nickname, int id) {
		CommentDTO comment = new CommentDTO();
		comment.setHpid(hpid);
		comment.setBody(body);
		comment.setNickname(nickname);
		comment.setUserid(id);
		
		commentRepository.insertComment(comment);
	}

	public void doModify(int id, String body) {
		commentRepository.doModify(id, body);
	}

	public void doDelete(int id) {
		commentRepository.doDelete(id);
	}


}
