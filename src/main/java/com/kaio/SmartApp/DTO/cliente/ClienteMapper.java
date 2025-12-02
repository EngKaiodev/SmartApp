package com.kaio.SmartApp.DTO.cliente;

import com.kaio.SmartApp.entity.UserModel;

public class ClienteMapper {
    public static ClienteGetResponse toResponse(UserModel user){
        return new ClienteGetResponse(
            user.getId(),
            user.getComplete_name()
        );
    }
}
