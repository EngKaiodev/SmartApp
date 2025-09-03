package com.kaio.SmartApp.DTO.horario_disponivel.response;

import java.time.LocalDate;
import java.time.LocalTime;

import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioDisponivelGetResponseDTO {
    private int id;
    private ProfissionalGetResponseDTO profissional;
    private LocalDate data;
    private LocalTime hora_inicio;
    private LocalTime hora_fim;
    @Enumerated(EnumType.STRING)
    private String status;
}
