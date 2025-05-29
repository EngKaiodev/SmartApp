package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.entity.Profissional;
import com.kaio.SmartApp.repository.ProfissionalRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    @Transactional(readOnly = true)
    public List<ProfissionalGetResponseDTO> SelectAll() {
        List<Profissional> profissionais = profissionalRepository.findAll();

        List<ProfissionalGetResponseDTO> responseDTOs = profissionais.stream()
        .map(Profissional::toGetDTO)
        .toList();

        return responseDTOs;
    }

    
    public ProfissionalGetResponseDTO selectById(int id){
        return selectEntityById(id).toGetDTO();
    }

    public Profissional selectEntityById(int id){
        return profissionalRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Profissional não encontrado")
        );
    }

    @Transactional
    public ProfissionalGetResponseDTO save(Profissional profissional) {
        Profissional profissionalSaved = profissionalRepository.save(profissional);
        return profissionalSaved.toGetDTO();
    }

    @Transactional
    public void deleteById(int id) {
        profissionalRepository.deleteById(id);
    }
}
