package com.kaio.SmartApp.DTO.profissional;

import com.kaio.SmartApp.DTO.user.request.UserRequestDTO;
import com.kaio.SmartApp.entity.Profissional;

public class ProfissionalMapper {
    public static Profissional userToProfissional(UserRequestDTO requestDTO){
        return new Profissional(
            0,
            requestDTO.getComplete_name(), 
            requestDTO.getPhone(), 
            requestDTO.getEmail(), 
            requestDTO.getPassword(), 
            requestDTO.getDocument(), 
            null, 
            null);
    }
}
