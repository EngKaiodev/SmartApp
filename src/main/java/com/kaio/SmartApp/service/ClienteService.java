package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.cliente.ClienteGetResponse;
import com.kaio.SmartApp.entity.Cliente;
import com.kaio.SmartApp.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<ClienteGetResponse> SelectAll(){

        List<Cliente> clientes = clienteRepository.findAll();

        List<ClienteGetResponse> clientesDTO = clientes.stream()
        .map(Cliente::toGetResponse)
        .toList();

        return clientesDTO;
    }

    @Transactional(readOnly = true)
    public ClienteGetResponse selectById(int id){

        Cliente cliente = clienteRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Cliente nao encontrado")
        );

        return cliente.toGetResponse();

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
