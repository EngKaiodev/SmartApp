package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.cliente.response.ClienteGetResponse;
import com.kaio.SmartApp.entity.Cliente;
import com.kaio.SmartApp.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<ClienteGetResponse> SelectAll() {

        List<Cliente> clientes = clienteRepository.findAll();

        List<ClienteGetResponse> clientesDTO = clientes.stream()
                .map(Cliente::toGetResponse)
                .toList();

        return clientesDTO;
    }

    @Transactional(readOnly = true)
    public ClienteGetResponse selectById(int id) {
        return selectEntityById(id).toGetResponse();
    }

    @Transactional(readOnly = true)
    public Cliente selectEntityById(int id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cliente com id " + id + " não encontrado"));
    }

    @Transactional
    public ClienteGetResponse save(Cliente cliente) {
        return clienteRepository.save(cliente).toGetResponse();
    }

    @Transactional
    public void deleteById(int id) {
        clienteRepository.deleteById(id);
    }

}
