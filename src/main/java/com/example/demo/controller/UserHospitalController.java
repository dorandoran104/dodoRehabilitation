package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.apikey.Apikey;
import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.HospitalDTO;
import com.example.demo.dto.PageCriteriaDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.service.CommentService;
import com.example.demo.service.HospitalService;

import lombok.AllArgsConstructor;

//병원 정보 컨트롤러
@Controller
@RequestMapping("/hospi")
@AllArgsConstructor
public class UserHospitalController {
	
	private HospitalService hospitalService;
	private CommentService commentService;
	
//	public UserHospitalController(HospitalService hospitalService, CommentService commentService) {
//		this.hospitalService = hospitalService;
//		this.commentService = commentService;
//	}
	//병원 리스트 조회
	@GetMapping("/getlist")
	public String getList(Model model, PageCriteriaDTO cri) {
		System.out.println(cri);
		List<HospitalDTO> list = hospitalService.getList(cri);
		
		int total = hospitalService.getTotal(cri);
		PageDTO pageDTO = new PageDTO(cri,total);
		
		model.addAttribute("list",list);
		model.addAttribute("pageCri",pageDTO);
		
		return "hospital/getlist";
	}
	//병원 상세 조회
	@GetMapping("/gethospital")
	public String getHospital(Model model, String hpid, PageCriteriaDTO cri) {
		HospitalDTO hospital = hospitalService.getHospital(hpid);
		List<CommentDTO> comment = commentService.getComments(hpid);
		
		model.addAttribute("hospital",hospital);
		model.addAttribute("comment",comment);
		
		model.addAttribute("cri",cri);
		System.out.println(cri);
		String kakaoApi = new Apikey().getKakao();
		model.addAttribute("api",kakaoApi);
		
		return "hospital/gethospital";
	}
}
