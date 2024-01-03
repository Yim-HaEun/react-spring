package com.kh.googleAPI2.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class UserGoogle {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="mg_seq")
	@SequenceGenerator(name="mg_seq",sequenceName="mg_seq",allocationSize =1)
	private Long id; //기본키
	private String email;
	private String username;
	
	public UserGoogle() {
		
	}
	public UserGoogle(String email, String username) {
		this.email = email;
		this.username = username;
	}

		

}
