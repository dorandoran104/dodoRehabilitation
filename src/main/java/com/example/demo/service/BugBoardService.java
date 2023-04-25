package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BugBoardDTO;
import com.example.demo.repository.BugBoardRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BugBoardService {
	private BugBoardRepository bugboardRepository;

	public List<BugBoardDTO> getList() {
		List<BugBoardDTO> list = bugboardRepository.getList();
		return list;
	}

	public void writeBboard(int userNum, String nickname, String title, String body, int secret){
		BugBoardDTO bugboardDTO = new BugBoardDTO();
		bugboardDTO.setTitle(title);
		bugboardDTO.setBody(body);
		bugboardDTO.setNickname(nickname);
		bugboardDTO.setUserNum(userNum);
		
		bugboardDTO.setSecret(secret);
		
		bugboardRepository.writeBboard(bugboardDTO);
	}

	public int getLastId() {
		int lastId = bugboardRepository.getLastId();
		return lastId;
	}

	public BugBoardDTO getBoard(int id) {
		BugBoardDTO bugboardDTO = bugboardRepository.getBoard(id);
		return bugboardDTO;
	}

	public void modifyBoard(int id, String title, String body, int secret) {
		BugBoardDTO bugboardDTO = new BugBoardDTO();
		bugboardDTO.setId(id);
		bugboardDTO.setTitle(title);
		bugboardDTO.setBody(body);
		bugboardDTO.setSecret(secret);
		
		bugboardRepository.modifyBoard(bugboardDTO);
		
	}

	public void deleteBoard(int id) {
		bugboardRepository.deleteBoard(id);
	}
}
