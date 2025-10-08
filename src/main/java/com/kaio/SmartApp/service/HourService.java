package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.hour.HourMapper;
import com.kaio.SmartApp.DTO.hour.request.HourRequest;
import com.kaio.SmartApp.DTO.hour.response.HourResponse;
import com.kaio.SmartApp.entity.Hours;
import com.kaio.SmartApp.repository.HourRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HourService {

    private final HourRepository repository;

    @Transactional(readOnly = false)
    public HourResponse save(HourRequest hour){
        Hours toSave = HourMapper.toEntity(hour);
        return HourMapper.toResponse(toSave);
    }

    @Transactional(readOnly = true)
    private Hours getEntityById(int id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Horário com id " + id + " não encontrado")
        );
    }

    @Transactional(readOnly = true)
    public List<Hours> getEntityByUserId(int id){
        return repository.findAllByUserId(id);
    }


}
