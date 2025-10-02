package com.kaio.SmartApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findByUserId(int userId);
}
