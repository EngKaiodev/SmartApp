package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.HorarioDisponivel;
import com.kaio.SmartApp.repository.HorarioDisponivelRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class HorarioDisponivelService {
    private final HorarioDisponivelRepository horarioDisponivelRepository;

    @Transactional(readOnly = true)
    public List<HorarioDisponivel> SelectAll(){
        return horarioDisponivelRepository.findAll();
    }

    @Transactional(readOnly = true)
    public HorarioDisponivel selectById(int id){
        return horarioDisponivelRepository.findById(id).orElseThrow(
            () -> new RuntimeException("não ha horarios disponiveis")
        );
    }
    
    @Transactional
    public HorarioDisponivel save(HorarioDisponivel horarioDisponivel){
        return horarioDisponivelRepository.save(horarioDisponivel);
    }

    @Transactional
    public void deleteById(int id){
        horarioDisponivelRepository.deleteById(id);
    }



}
