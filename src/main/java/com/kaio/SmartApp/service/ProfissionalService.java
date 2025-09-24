package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.DTO.user.UserMapper;
import com.kaio.SmartApp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfissionalService {

    private final UserRepository profissionalRepository;

    @Transactional(readOnly = true)
    public List<ProfissionalGetResponseDTO> getAll(){
        List<Object[]> models = profissionalRepository.findPros();
        List<ProfissionalGetResponseDTO> response = models.stream()
        .map(UserMapper::toProResponse)
        .toList();
        return response;
    }
}
