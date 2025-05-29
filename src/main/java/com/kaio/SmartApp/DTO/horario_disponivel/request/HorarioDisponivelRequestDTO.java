package com.kaio.SmartApp.DTO.horario_disponivel.request;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioDisponivelRequestDTO {
    private int id_profissional;
    private LocalDate data;
    private LocalTime hora_inicio;
    private LocalTime hora_fim;
    @Enumerated(EnumType.STRING)
    private String status;
}
