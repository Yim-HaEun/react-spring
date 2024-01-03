package com.kh.googleAPI2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.googleAPI2.model.UserGoogle;

public interface UserGoogleRepository extends JpaRepository<UserGoogle, Long> {
    Optional<UserGoogle> findByUsername(String username);
}