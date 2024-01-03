package com.kh.googleAPI2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kh.googleAPI2.model.UserGoogle;

@Service
public interface UserService {
	 Optional<UserGoogle> findByUsername(String username);
	    void saveUser(UserGoogle user);
}