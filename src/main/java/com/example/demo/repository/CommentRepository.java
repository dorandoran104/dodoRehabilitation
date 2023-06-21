package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.CommentVO;
@Mapper
public interface CommentRepository {

	List<CommentVO> getComments(String hpid);

	int insertComment(CommentVO comment);

	int getLastId();

	CommentVO getComment(int lastId);

	int deleteComment(int id);

	int modifyComment(CommentVO commentDTO);

}
