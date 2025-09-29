package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Servicos;
import com.kaio.SmartApp.repository.ServicosRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServicosService {

    private final ServicosRepository servicosRepository;

    @Transactional(readOnly = true)
    public List<Servicos> SelectAll() {
        return servicosRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Servicos selectById(int id) {
        return servicosRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Serviço com id " + id + " não encontrado"));
    }

    @Transactional
    public Servicos save(Servicos servicos) {
        return servicosRepository.save(servicos);
    }

    @Transactional
    public void deleteById(int id) {
        servicosRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Servicos> getAllByProId(int id){
        return servicosRepository.findAllByProId(id);
    }
}
