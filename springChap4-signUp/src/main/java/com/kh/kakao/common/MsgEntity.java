package com.kh.kakao.common;
//응답받은 결과를 담기위한 Entity

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class MsgEntity {
	private String msg;
	private Object result;
	/*
	@AllArgsConstructor 가 대체
	public MsgEntity(String msg,Object result) {
		this.msg = msg;
		this.result = result;
	}
	*/

}
