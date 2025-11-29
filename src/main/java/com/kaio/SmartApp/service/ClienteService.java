package com.kaio.SmartApp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.address.request.AddressEditRequest;
import com.kaio.SmartApp.DTO.address.response.AddressResponse;
import com.kaio.SmartApp.DTO.user.UserMapper;
import com.kaio.SmartApp.DTO.user.request.UserEditRequest;
import com.kaio.SmartApp.DTO.user.response.MyselfResponse;
import com.kaio.SmartApp.entity.UserModel;
import com.kaio.SmartApp.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final UserRepository clienteRepository;
    private final AddressService addressService;

    @Transactional(readOnly = true)
    public MyselfResponse mySelf(String email){
        UserModel user = getEntityByEmail(email);
        AddressResponse address = addressService.getEntityByUserId(user.getId());
        return UserMapper.toMyselfResponse(user, address);
    }

    @Transactional(readOnly = true)
    public UserModel getEntityByEmail(String email){
        return clienteRepository.findByEmail(email).orElseThrow(
            () -> new EntityNotFoundException("Usuário com email " + email + " não encontrado.")
        );
    }

    public MyselfResponse editMyself(UserEditRequest request, String email){
        UserModel user = getEntityByEmail(email);

        UserMapper.upgradeWithEditRequest(user, request);

        user = clienteRepository.save(user);

        addressService.editAddress(
            new AddressEditRequest(user.getId(), request.getZipcode(), request.getAddress(), request.getNumber())
        );

        return mySelf(email);
    }

}
