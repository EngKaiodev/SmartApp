package com.kaio.SmartApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);
    List<UserModel> findAllByType(Integer type);
}
