package com.kh.kakao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.kakao.service.kakaoService;
import com.kh.naver.service.NaverService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //final 필수
public class HomeController {
	private final kakaoService kService;
	private final NaverService naverService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("kakaoUrl",kService.getKakaoLogin());
		model.addAttribute("naverUrl",naverService.getNaverLogin());
		return "index";
	}
}
