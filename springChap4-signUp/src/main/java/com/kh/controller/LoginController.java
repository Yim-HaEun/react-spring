package com.kh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.model.Member;
import com.kh.service.MemberService;

@Controller
@RequestMapping("/members")
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String LoginForm() {
		return "login";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	

}
