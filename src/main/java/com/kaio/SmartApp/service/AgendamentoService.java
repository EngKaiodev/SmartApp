package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Agendamento;
import com.kaio.SmartApp.repository.AgendamentoRepository;

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
