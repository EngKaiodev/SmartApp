package com.kaio.SmartApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.Agendamento;

public interface  AgendamentoRepository extends JpaRepository<Agendamento, Integer>{}
