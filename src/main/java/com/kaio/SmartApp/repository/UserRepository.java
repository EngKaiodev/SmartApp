package com.kaio.SmartApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUsername(String username);
}
