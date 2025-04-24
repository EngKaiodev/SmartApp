package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaio.SmartApp.entity.Agendamento;
import com.kaio.SmartApp.repository.AgendamentoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class AgendamentoService {
    private final  AgendamentoRepository agendamentoRepository;

    @Transactional(readOnly = true)
    public List<Agendamento> SelectAll(){
        return agendamentoRepository.findAll();
    }


}
