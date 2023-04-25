package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDTO {
	//병원 고유 id
	private String hpid;
	//병원명
	private String dutyName;
	
	
	//0은 병원 1은 의원
	private boolean dutyDivNam;
	private String dutyAddr;
	private String dutyTel1;
	
	//밑으로는 상세보기해야 보이는 곳
	//1~7 월~일 8 공휴일
	private String dutyTime1s;
	private String dutyTime2s;
	private String dutyTime3s;
	private String dutyTime4s;
	private String dutyTime5s;
	private String dutyTime6s;
	private String dutyTime7s;
	private String dutyTime8s;
	//병원 위도
	private String wgs84Lat;
	//병원 경도
	private String wgs84Lon;
}
