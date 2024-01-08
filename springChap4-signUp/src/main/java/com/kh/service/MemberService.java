package com.kh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mapper.MembersMapper;
import com.kh.model.Member;

@Service
public class MemberService {
	@Autowired
	private MembersMapper membersMapper;
	
	//회원 정보 저장하기
	public void signUpMember(Member member) {
		membersMapper.insertMember(member);
		
	}
	//로그인하기
	public void login(String username) {
		membersMapper.loginMember(username);
	}
}
