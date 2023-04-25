package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.AdminBoardDTO;

@Mapper
public interface AdminBoardRepository {

	@Insert("""
			insert into hospitallist
				(hpid,
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
				wgs84Lon)
			values(
				#{hpid},
				#{dutyName},
				#{dutyDivNam},
				#{dutyAddr},
				#{dutyTel1},
				#{dutyTime1s,jdbcType=VARCHAR},
				#{dutyTime2s,jdbcType=VARCHAR},
				#{dutyTime3s,jdbcType=VARCHAR},
				#{dutyTime4s,jdbcType=VARCHAR},
				#{dutyTime5s,jdbcType=VARCHAR},
				#{dutyTime6s,jdbcType=VARCHAR},
				#{dutyTime7s,jdbcType=VARCHAR},
				#{dutyTime8s,jdbcType=VARCHAR},
				#{wgs84Lat,jdbcType=VARCHAR},
				#{wgs84Lon,jdbcType=VARCHAR}
				)
			""")
	void insertHospital(@Param("hpid") String hpid, @Param("dutyName") String dutyName,
			@Param("dutyDivNam") String dutyDivNam, @Param("dutyAddr") String dutyAddr,
			@Param("dutyTel1") String dutyTel1, @Param("dutyTime1s") String dutyTime1s,
			@Param("dutyTime2s") String dutyTime2s, @Param("dutyTime3s") String dutyTime3s,
			@Param("dutyTime4s") String dutyTime4s, @Param("dutyTime5s") String dutyTime5s,
			@Param("dutyTime6s") String dutyTime6s, @Param("dutyTime7s") String dutyTime7s,
			@Param("dutyTime8s") String dutyTime8s, @Param("wgs84Lat") String wgs84Lat,
			@Param("wgs84Lon") String wgs84Lon);

	void writeAction(AdminBoardDTO adminBoardDTO);

	List<AdminBoardDTO> getBoardList();

}
