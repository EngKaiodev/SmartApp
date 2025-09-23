package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.user.UserMapper;
import com.kaio.SmartApp.DTO.user.response.UserResponseDTO;
import com.kaio.SmartApp.entity.UserModel;
import com.kaio.SmartApp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfissionalService {

    private final UserRepository profissionalRepository;

    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAll(){
        List<UserModel> models = profissionalRepository.findAllByType(1);
        List<UserResponseDTO> response = models.stream()
        .map(UserMapper::toResponse)
        .toList();
        return response;
    }
}
