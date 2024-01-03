package com.kh.springchap1.model;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
//User이름을 사용했을 때 테이블이 부적합하다 나오면
//Users 변경해서 만들어줌
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator="uses_seq")
	@SequenceGenerator(name="users_seq", 
	sequenceName="users_seq",
	allocationSize=1)
	private Long id;
	private String username;
	private String email;

}