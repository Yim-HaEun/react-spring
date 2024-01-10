package com.kh.naver.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.kakao.common.MsgEntity;
import com.kh.naver.dto.NaverDTO;
import com.kh.naver.service.NaverService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/naver")
public class  NaverController {
	private final NaverService naverService;
	
	@GetMapping("/callback")
	public ResponseEntity<MsgEntity> callback(HttpServletRequest request) throws Exception{
		NaverDTO naverInfo = naverService.getNaverInfo(request.getParameter("code"));
		
		return ResponseEntity.ok().body(new MsgEntity("Success",naverInfo));
	}
	

}
