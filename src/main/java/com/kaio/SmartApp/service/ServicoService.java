package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.servico.ServicoDTO;
import com.kaio.SmartApp.entity.Profissional;
import com.kaio.SmartApp.entity.Servico;
import com.kaio.SmartApp.repository.ProfissionalRepository;
import com.kaio.SmartApp.repository.ServicoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class ServicoService {
    private final ServicoRepository servicoRepository;
    private final ProfissionalService profissionalService;

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
    public Servico save(ServicoDTO servico){
        Profissional profissional = profissionalService.selectById(servico.getId_profissional());
        Servico servicoResponse = servico.toEntity(profissional);
        return servicoRepository.save(servicoResponse);
    }

    @Transactional
    public void deleteById(int id){
        servicoRepository.deleteById(id);
    }

}
