package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.kh.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //final 필수
@RequestMapping("/login")
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/")
	public String memberLogin() {
		//로그인할 때 필요한 코드를 작성해주면 됨 
		return "redirect:/";
	
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

}
