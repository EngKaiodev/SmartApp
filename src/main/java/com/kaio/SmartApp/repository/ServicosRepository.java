package com.kaio.SmartApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.Servicos;

public interface ServicosRepository extends JpaRepository<Servicos, Integer>{

    List<Servicos> findAllByProId(int proId);

}
