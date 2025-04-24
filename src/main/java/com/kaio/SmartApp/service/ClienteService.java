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
}
