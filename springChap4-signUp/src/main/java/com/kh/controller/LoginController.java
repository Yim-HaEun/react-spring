package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.kakao.service.kakaoService;
import com.kh.naver.service.NaverService;
import com.kh.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //final 필수
@RequestMapping("/members")
public class LoginController {

	private final MemberService memberService;
	private final kakaoService kService;
	private final NaverService naverService;
	
	@GetMapping("/login")
	public String LoginForm(Model model) {
		model.addAttribute("kakaoUrl",kService.getKakaoLogin());
		model.addAttribute("naverUrl",naverService.getNaverLogin());
		return "login";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	

}
