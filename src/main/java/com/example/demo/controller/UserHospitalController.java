package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.HospitalDTO;
import com.example.demo.service.CommentService;
import com.example.demo.service.HospitalService;

//병원 정보 컨트롤러
@Controller
@RequestMapping("/hospi")
public class UserHospitalController {
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private CommentService commentService;
	
//	public UserHospitalController(HospitalService hospitalService, CommentService commentService) {
//		this.hospitalService = hospitalService;
//		this.commentService = commentService;
//	}
	//병원 리스트 조회
	@GetMapping("/getlist")
	public String getList(Model model, int page, int type, String location) {
		List<HospitalDTO> list = hospitalService.getList(type,location,page);
		int size = hospitalService.getLastId(type,location);
		model.addAttribute("size",size);
		model.addAttribute("list",list);
		model.addAttribute("page",page);
		model.addAttribute("type",type);
		model.addAttribute("location",location);
		return "hospital/getlist";
	}
	//특정 병원 조회
	@GetMapping("/gethospital")
	public String getHospital(Model model, String hpid,int page, int type, String location) throws UnsupportedEncodingException {
		HospitalDTO hospital = hospitalService.getHospital(hpid);
		List<CommentDTO> comment = commentService.getComments(hpid);
		model.addAttribute("hospital",hospital);
		model.addAttribute("comment",comment);
		model.addAttribute("page",page);
		model.addAttribute("type",type);
		model.addAttribute("location",location);
		return "hospital/gethospital";
	}
}
