package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaio.SmartApp.entity.HorarioDisponivel;
import com.kaio.SmartApp.repository.HorarioDisponivelRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class HorarioDisponivelService {
    private final HorarioDisponivelRepository horarioDisponivelRepository;

    @Transactional(readOnly = true)
    public List<HorarioDisponivel> SelectAll(){
        return horarioDisponivelRepository.findAll();
    }


}
