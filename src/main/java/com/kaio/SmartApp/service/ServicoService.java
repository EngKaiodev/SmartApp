package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Servico;
import com.kaio.SmartApp.repository.ServicoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class ServicoService {
    private final ServicoRepository servicoRepository;

    @Transactional(readOnly = true)
    public List<Servico> SelectAll(){
        return servicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Servico selectById(int id){
        return servicoRepository.findById(id).orElseThrow(
            () -> new RuntimeException("seviço nao localizado")
        );
    }

    @Transactional
    public Servico save(Servico servico){
        return servicoRepository.save(servico);
    }

    @Transactional
    public void deleteById(int id){
        servicoRepository.deleteById(id);
    }

}
