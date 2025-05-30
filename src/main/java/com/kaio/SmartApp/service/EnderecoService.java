package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Endereco;
import com.kaio.SmartApp.repository.EnderecoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco save(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    @Transactional(readOnly = true)
    public Endereco selectById(int id){
        return enderecoRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Endereço com id " + id + " não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<Endereco> selectAll(){
        return enderecoRepository.findAll();
    }

    @Transactional
    public void deleteByID(int id){
        enderecoRepository.deleteById(id);
    }

}
