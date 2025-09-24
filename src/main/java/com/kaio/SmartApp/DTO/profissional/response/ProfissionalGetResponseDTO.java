package com.kaio.SmartApp.DTO.profissional.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalGetResponseDTO {
    private int id;
    private String complete_name;
    private String phone;
    private Double rate;
    private int reviewsCount;
}
