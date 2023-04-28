package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.HospitalDTO;
import com.example.demo.dto.PageCriteriaDTO;

@Mapper
public interface HospitalRepository {

	List<HospitalDTO> getList(PageCriteriaDTO cri);
	
	
	List<HospitalDTO> getKeyWoardList(PageCriteriaDTO cri);

	@Select("""
			select
				hpid,
				dutyName,
				dutyDivNam,
				dutyAddr,
				dutyTel1,
				dutyTime1s,
				dutyTime2s,
				dutyTime3s,
				dutyTime4s,
				dutyTime5s,
				dutyTime6s,
				dutyTime7s,
				dutyTime8s,
				wgs84Lat,
				wgs84Lon
			from hospitallist
			where hpid = #{hpid}
			""")
	HospitalDTO getHospital(String hpid);

	
	int getTotal(PageCriteriaDTO cri);

}
