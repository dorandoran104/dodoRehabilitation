package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.HospitalDTO;

@Mapper
public interface HospitalRepository {

	@Select("""
			<script>
			select
				*
			from 
				(select rownum as r, h.*
				from hospitallist h
				where 
				dutyDivNam = #{type}
				<if test=" location !='' ">
					and dutyAddr like '%'||#{location}||'%' 
				</if>
				) h
			where
				r between #{start} and #{end}
			</script>
			""")
	List<HospitalDTO> getList( @Param("type") int type, @Param("location") String location, @Param("start") int start, @Param("end") int end);

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

	@Select("""
			<script>
			select
				count(dutyname)
			from 
				hospitallist
			where
				dutyDivNam = #{type}
				<if test=" location !='' ">
					and dutyAddr like '%'||#{location}||'%' 
				</if>
			</script>
			""")
	int getLastId(@Param("type") int type,@Param("location") String location);

}
