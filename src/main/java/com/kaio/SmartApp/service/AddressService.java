package com.kaio.SmartApp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.address.AddressMapper;
import com.kaio.SmartApp.DTO.address.request.AddressEditRequest;
import com.kaio.SmartApp.DTO.address.response.AddressResponse;
import com.kaio.SmartApp.entity.Address;
import com.kaio.SmartApp.repository.AddressRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository repository;

    @Transactional(readOnly = false)
    public AddressResponse save(Address request){
        Address response = repository.save(request);
        return AddressMapper.toResponse(response);
    }

    @Transactional(readOnly = true)
    public Address getEntityById(int id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Endereço com id " + id + " não encontrado.")
        );
    }

    public AddressResponse getById(int id){
        return AddressMapper.toResponse(getEntityById(id));
    }

    @Transactional(readOnly = true)
    public AddressResponse getEntityByUserId(int id){
        Address address = repository.findByUserId(id).orElseThrow(
            () -> new EntityNotFoundException("Endereço com userDd " + id + " não encontrado.")
        );
        return AddressMapper.toResponse(address);
    }

    @Transactional(readOnly = false)
    public AddressResponse editAddress(AddressEditRequest request){
        Address address = repository.findByUserId(request.getUserId()).orElseThrow(
            () -> new EntityNotFoundException("Endereço com userDd " + request.getUserId() + " não encontrado.")
        );

        AddressMapper.upgrade(address, request);

        address = repository.save(address);

        return AddressMapper.toResponse(address);
    }

}
