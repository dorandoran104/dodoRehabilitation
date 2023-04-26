package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HospitalDTO;
import com.example.demo.dto.PageCriteriaDTO;
import com.example.demo.repository.HospitalRepository;

@Service
public class HospitalService {
	
	private HospitalRepository hospitalRepository;

	HospitalService(HospitalRepository hospitalRepository) {
		this.hospitalRepository = hospitalRepository;
	}		
	
	//page로 db 가져올 범위 정하기
	public List<HospitalDTO> getList(PageCriteriaDTO cri) {
		List<HospitalDTO> list = hospitalRepository.getList(cri);
		return list;
	}

	public HospitalDTO getHospital(String hpid) {
		HospitalDTO hospital = hospitalRepository.getHospital(hpid);
		return hospital;
	}

	public int getTotal(int type, String location) {
		int getTotal = hospitalRepository.getTotal(type, location);
		return getTotal;
	}


}
