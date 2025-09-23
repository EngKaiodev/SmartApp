package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.horario_disponivel.request.HorarioDisponivelRequestDTO;
import com.kaio.SmartApp.DTO.horario_disponivel.response.HorarioDisponivelGetResponseDTO;
import com.kaio.SmartApp.entity.HorarioDisponivel;
import com.kaio.SmartApp.entity.Profissional;
import com.kaio.SmartApp.repository.HorarioDisponivelRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class HorarioDisponivelService {
    private final HorarioDisponivelRepository horarioDisponivelRepository;
    private final ProfissionalService profissionalService;

    @Transactional(readOnly = true)
    public List<HorarioDisponivelGetResponseDTO> SelectAll() {
        List<HorarioDisponivel> horarioDisponiveis = horarioDisponivelRepository.findAll();

        List<HorarioDisponivelGetResponseDTO> responseDTOs = horarioDisponiveis.stream()
                .map(HorarioDisponivel::toGetDTO)
                .toList();
                
        return responseDTOs;
    }

    @Transactional(readOnly = true)
    public HorarioDisponivelGetResponseDTO selectById(int id) {
        return selectEntityByID(id).toGetDTO();
    }

    @Transactional(readOnly = true)
    public HorarioDisponivel selectEntityByID(int id) {
        return horarioDisponivelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Horário com id " + id + " não encontrado"));
    }

    /*@Transactional
    public HorarioDisponivelGetResponseDTO save(HorarioDisponivelRequestDTO horarioDisponivel) {
        Profissional profissional = profissionalService.selectEntityById(horarioDisponivel.getId_profissional());
        HorarioDisponivel response = horarioDisponivelRepository.save(horarioDisponivel.toEntity(profissional));
        return response.toGetDTO();
    }*/

    @Transactional
    public void deleteById(int id) {
        horarioDisponivelRepository.deleteById(id);
    }

}
