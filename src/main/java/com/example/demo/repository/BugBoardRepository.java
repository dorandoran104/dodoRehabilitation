package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.example.demo.dto.BugBoardDTO;

@Mapper
public interface BugBoardRepository {

	List<BugBoardDTO> getList();

	void writeBboard(BugBoardDTO bugboardDTO);

	int getLastId();

	BugBoardDTO getBoard(int id);

	void modifyBoard(BugBoardDTO bugboardDTO);

	void deleteBoard(int id);

}
