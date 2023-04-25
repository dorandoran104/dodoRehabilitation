package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HospitalDTO;
import com.example.demo.repository.HospitalRepository;

@Service
public class HospitalService {
	
	private HospitalRepository hospitalRepository;

	HospitalService(HospitalRepository hospitalRepository) {
		this.hospitalRepository = hospitalRepository;
	}		
	
	//page로 db 가져올 범위 정하기
	public List<HospitalDTO> getList(int type, String location, int page) {
		int start = (page-1)*15;
		int end = page*15-1;
		List<HospitalDTO> list = hospitalRepository.getList(type, location,start, end);
		return list;
	}

	public HospitalDTO getHospital(String hpid) {
		HospitalDTO hospital = hospitalRepository.getHospital(hpid);
		return hospital;
	}

	public int getLastId(int type, String location) {
		int getLastId = hospitalRepository.getLastId(type, location);
		if(getLastId%15 != 0) {
			getLastId= getLastId/15+1;
		}
		return getLastId;
	}


}
