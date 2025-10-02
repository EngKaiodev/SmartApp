package com.kaio.SmartApp.DTO.user;

import com.kaio.SmartApp.DTO.address.response.AddressResponse;
import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.DTO.user.request.UserRequestDTO;
import com.kaio.SmartApp.DTO.user.response.MyselfResponse;
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

    public static ProfissionalGetResponseDTO toProResponse(Object[] userObj){
        ProfissionalGetResponseDTO dto = new ProfissionalGetResponseDTO();
        dto.setId(((Number) userObj[0]).intValue());   
        dto.setCompleteName((String) userObj[1]);     
        dto.setPhone((String) userObj[2]);             
        dto.setRate(userObj[3] != null ? ((Number) userObj[3]).doubleValue() : null); 
        dto.setReviewsCount(((Number) userObj[4]).intValue());
        return dto;
    }

    public static MyselfResponse toMyselfResponse(UserModel userModel, AddressResponse address){
        return new MyselfResponse(
            userModel.getId(),
            userModel.getComplete_name(),
            userModel.getPhone(),
            userModel.getEmail(), 
            userModel.getDocument(), 
            userModel.getType(),
            address
            );
    }
}
