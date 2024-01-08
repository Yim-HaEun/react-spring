package com.kh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.mapper.MembersMapper;
import com.kh.model.Member;

@Service
public class MemberService {
	@Autowired
	private MembersMapper membersMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	//회원 정보 저장하기
	public Member signUpMember(String username, String password, String fullName, String email, String role) {
		
		Member member = new Member();
		
		member.setUsername(username);
		member.setPassword(passwordEncoder.encode(password));
		member.setFullName(fullName);
		member.setEmail(email);
		member.setRole(role);
		membersMapper.insertMember(member);
		return member;
		
	}
	//로그인하기
	public void login(String username) {
		membersMapper.loginMember(username);
	}
}
