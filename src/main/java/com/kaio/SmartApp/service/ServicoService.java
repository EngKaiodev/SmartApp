package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.servico.request.ServicoRequestDTO;
import com.kaio.SmartApp.DTO.servico.response.ServicoGetRespondeDTO;
import com.kaio.SmartApp.entity.Profissional;
import com.kaio.SmartApp.entity.Servico;
import com.kaio.SmartApp.repository.ServicoRepository;

import jakarta.persistence.EntityNotFoundException;
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
    public ServicoGetRespondeDTO selectByID(int id){
        return selectEntityById(id).toGetDTO();
    }

    @Transactional(readOnly = true)
    public Servico selectEntityById(int id){
        return servicoRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Serviço com id " + id + " não encontrado"));
    }

    @Transactional
    public ServicoGetRespondeDTO save(ServicoRequestDTO servico){
        Profissional profissional = profissionalService.selectEntityById(servico.getId_profissional());
        Servico servicoSaved = servicoRepository.save(servico.toEntity(profissional));
        return servicoSaved.toGetDTO();
    }

    @Transactional
    public void deleteById(int id){
        servicoRepository.deleteById(id);
    }

}
