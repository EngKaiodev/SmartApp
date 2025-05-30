package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Especialidade;
import com.kaio.SmartApp.repository.EspecialdiadesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EspecialidadeService {
    private final EspecialdiadesRepository especialdiadesRepository;

    @Transactional
    public Especialidade save(Especialidade especialidade) {
        return especialdiadesRepository.save(especialidade);
    }

    @Transactional(readOnly = true)
    public Especialidade selectById(int id) {
        return especialdiadesRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Especialidade não encontrada"));
    }

    @Transactional(readOnly = true)
    public List<Especialidade> selectAll(){
        return especialdiadesRepository.findAll();
    }

    @Transactional
    public void deleteById(int id){
        especialdiadesRepository.deleteById(id);
    }
}
