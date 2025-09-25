package com.kaio.SmartApp.DTO.profissional.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProfissionalGetResponseDTO {

    private int id;
    private String completeName;
    private String phone;
    private Double rate;
    private int reviewsCount;

}
