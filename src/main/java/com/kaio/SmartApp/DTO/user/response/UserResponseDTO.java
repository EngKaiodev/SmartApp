package com.kaio.SmartApp.DTO.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserResponseDTO {
    private int id;
    private String complete_name;
    private String phone;
    private String email;
}
