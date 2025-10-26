package com.kaio.SmartApp.DTO.reviews.response;

import java.time.LocalDateTime;

import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.DTO.user.response.UserResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReviewResponse {
    private int id;
    private ProfissionalGetResponseDTO profissional;
    private UserResponseDTO usuario;
    private int review;
    private String comment;
    private LocalDateTime date;
}
