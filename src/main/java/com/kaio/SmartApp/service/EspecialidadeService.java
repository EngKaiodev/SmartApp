package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Servicos;
import com.kaio.SmartApp.repository.EspecialdiadesRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EspecialidadeService {
    private final EspecialdiadesRepository especialdiadesRepository;

    @Transactional
    public Servicos save(Servicos especialidade) {
        return especialdiadesRepository.save(especialidade);
    }

    @Transactional(readOnly = true)
    public Servicos selectById(int id) {
        return especialdiadesRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Especialidade com id " + id + " não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<Servicos> selectAll(){
        return especialdiadesRepository.findAll();
    }

    @Transactional
    public void deleteById(int id){
        especialdiadesRepository.deleteById(id);
    }
}
