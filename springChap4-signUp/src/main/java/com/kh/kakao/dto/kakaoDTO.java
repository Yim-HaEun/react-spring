package com.kh.kakao.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class kakaoDTO {
	private long id;
	private String email;
	private String nickname;
}
