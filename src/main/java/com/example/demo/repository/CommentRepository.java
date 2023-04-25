package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.CommentDTO;
@Mapper
public interface CommentRepository {

	List<CommentDTO> getComments(String hpid);

	void insertComment(CommentDTO comment);

	void doModify(@Param("id")int id,@Param("body") String body);

	void doDelete(int id);

}