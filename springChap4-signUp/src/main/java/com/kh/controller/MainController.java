package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.model.Member;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String showMain() {
		return "/index";
	}
	
	

}
