package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Cliente;
import com.kaio.SmartApp.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<Cliente> SelectAll(){
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente selectById(int id){
        return clienteRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Cliente nao encontrado")
        );

    }

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteById(int id){
        clienteRepository.deleteById(id);
    }

    

}
