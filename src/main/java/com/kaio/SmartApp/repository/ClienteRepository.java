package com.kaio.SmartApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{}
