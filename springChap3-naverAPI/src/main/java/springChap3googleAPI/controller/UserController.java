package springChap3googleAPI.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/login")
	public String loginPage() {
		return "index";
	}
	//구글 로그인을 위한 URL 추가
	@GetMapping("/ouath2/authorization/google")
	public String googleLogin() {
		return "redirect:/ouath2/authorization/google";
	}
	
	@GetMapping("/loginSuccess")
	public String loginSuccess(@AuthenticationPrincipal OAuth2User principal, Model model) {
		System.out.println("OAuth2User Attribute : " + principal.getAttributes());
		model.addAttribute("name", principal.getAttribute("name"));
		model.addAttribute("email", principal.getAttribute("email"));
		return "loginSuccess";
		
	}
}