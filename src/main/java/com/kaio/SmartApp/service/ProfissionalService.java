package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Profissional;
import com.kaio.SmartApp.repository.ProfissionalRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    @Transactional(readOnly = true)
    public List<Profissional> SelectAll(){
        return profissionalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Profissional selectById(int id){
        return profissionalRepository.findById(id);
    }

    @Transactional
    public Profissional save(Profissional profissional){
        return profissionalRepository.save(profissional);
    }

    @Transactional
    public void deleteById(int id){
        profissionalRepository.deleteById(id);
    }
}
