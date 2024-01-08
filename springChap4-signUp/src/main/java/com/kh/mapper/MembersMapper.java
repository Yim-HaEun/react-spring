package com.kh.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.model.Member;

@Mapper
public interface MembersMapper {
	void insertMember(Member member);

	Member loginMember(String username);
	
	

}
