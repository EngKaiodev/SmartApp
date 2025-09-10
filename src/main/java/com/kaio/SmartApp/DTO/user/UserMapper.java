package com.kaio.SmartApp.DTO.user;

import com.kaio.SmartApp.DTO.user.request.UserRequestDTO;
import com.kaio.SmartApp.DTO.user.response.UserResponseDTO;
import com.kaio.SmartApp.entity.UserModel;

public final class UserMapper {
    private UserMapper() {}

    public static UserModel toEntity(UserRequestDTO request) {
        UserModel model = new UserModel();
        model.setComplete_name(request.getComplete_name());
        model.setPassword(request.getPassword());
        model.setPhone(request.getPhone());
        model.setEmail(request.getEmail());
        model.setDocument(request.getDocument());
        model.setType(request.getType());
        return model;
    }

    public static UserResponseDTO toResponse(UserModel model) {
        return new UserResponseDTO(
            model.getId(),
            model.getComplete_name(),
            model.getPhone(),
            model.getEmail()
        );
    }

    public static void upgrade(UserModel model, UserRequestDTO request) {
        model.setComplete_name(request.getComplete_name());
        model.setPassword(request.getPassword());
        model.setPhone(request.getPhone());
        model.setEmail(request.getEmail());
        model.setDocument(request.getDocument());
        model.setType(request.getType());
    }
}
