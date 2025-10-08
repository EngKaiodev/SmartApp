package com.kaio.SmartApp.DTO.hour.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class HourRequest {
    @NotNull(message = "userId é obrigatório")
    @Min(value = 1, message = "userId mínimo é 1")
    @Max(value = 7, message = "userId máximo é 7")
    private int userId;

    @NotNull(message = "Dia é obrigatório")
    @Min(value = 1, message = "Dia mínimo é 1 (segunda-feira)")
    @Max(value = 7, message = "Dia máximo é 7 (domingo)")
    private int day; // 1 = segunda ... 7 = domingo

    @Min(value = 0, message = "Hora mínima é 0")
    @Max(value = 23, message = "Hora máxima é 23")
    private int initHourMorning;

    @Min(value = 0, message = "Hora mínima é 0")
    @Max(value = 23, message = "Hora máxima é 23")
    private int endHourMorning;

    @Min(value = 0, message = "Hora mínima é 0")
    @Max(value = 23, message = "Hora máxima é 23")
    private int initHourAfternoon;

    @Min(value = 0, message = "Hora mínima é 0")
    @Max(value = 23, message = "Hora máxima é 23")
    private int endHourAfternoon;
}
