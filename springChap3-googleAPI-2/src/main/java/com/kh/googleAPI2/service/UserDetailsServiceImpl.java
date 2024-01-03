package com.kh.googleAPI2.service;

import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.googleAPI2.model.UserGoogle;
import com.kh.googleAPI2.repository.UserGoogleRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserGoogleRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserGoogle user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                "",//"{noop}", 
                Collections.emptyList());
    }
}