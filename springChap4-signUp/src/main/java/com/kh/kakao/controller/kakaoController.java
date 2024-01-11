package com.kh.kakao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.kakao.common.MsgEntity;
import com.kh.kakao.dto.kakaoDTO;
import com.kh.kakao.service.kakaoService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/kakao")

public class kakaoController {
	private final kakaoService kService;
	
	@GetMapping("/callback")
	//결과에 대한 내용을 담을 Entity 
	public ResponseEntity<MsgEntity> callback(HttpServletRequest request) throws Exception{
		kakaoDTO kakaoInfo = kService.getKakaoInfo(request.getParameter("code"));
		
		return ResponseEntity.ok().body(new MsgEntity("Success",kakaoInfo));
	}

}
