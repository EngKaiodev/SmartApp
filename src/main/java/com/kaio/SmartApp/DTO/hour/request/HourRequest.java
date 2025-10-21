package com.kaio.SmartApp.DTO.hour.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class HourRequest {

    @NotNull(message = "O campo userId é obrigatório.")
    @Min(value = 1, message = "O userId deve ser maior ou igual a 1.")
    private Integer userId;

    @NotNull(message = "A hora inicial é obrigatória.")
    private LocalDateTime initHour;

    @NotNull(message = "A hora final é obrigatória.")
    private LocalDateTime endHour;

    @NotBlank(message = "O status é obrigatório.")
    @Pattern(regexp = "^(booked|opened)$", message = "O status deve ser 'booked' ou 'opened'.")
    private String status;

}
