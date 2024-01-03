package com.kh.googleAPI2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.googleAPI2.model.UserGoogle;
import com.kh.googleAPI2.repository.UserGoogleRepository;



@Service
public class UserServiceImpl implements UserService {
    private final UserGoogleRepository userGoogleRepository;

    @Autowired
    public UserServiceImpl(UserGoogleRepository userGoogleRepository) {
        this.userGoogleRepository = userGoogleRepository;
    }

    @Override
    public Optional<UserGoogle> findByUsername(String username) {
        return userGoogleRepository.findByUsername(username);
    }

    @Override
    public void saveUser(UserGoogle user) {
        userGoogleRepository.save(user);
    }
}