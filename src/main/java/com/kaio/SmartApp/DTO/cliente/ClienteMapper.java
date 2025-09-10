package com.kaio.SmartApp.DTO.cliente;

import com.kaio.SmartApp.DTO.user.request.UserRequestDTO;
import com.kaio.SmartApp.entity.Cliente;

public class ClienteMapper {
    public static Cliente userToCliente(UserRequestDTO requestDTO){
        return new Cliente(0,
        requestDTO.getComplete_name(),
        requestDTO.getEmail(),
        requestDTO.getEmail(),
        requestDTO.getPassword(),
        requestDTO.getDocument(), 
        null, 
        null);
    }
}
