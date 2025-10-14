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

    @NotNull
    @Min(1)
    private Integer userId;

    @NotNull
    @Min(1)
    @Max(7)
    private Integer day; // 1 = segunda ... 7 = domingo

    @Min(0) @Max(23)
    private int initHourMorning;

    @Min(0) @Max(59)
    private int initMinuteMorning;

    @Min(0) @Max(23)
    private int endHourMorning;

    @Min(0) @Max(59)
    private int endMinuteMorning;

    @Min(0) @Max(23)
    private int initHourAfternoon;

    @Min(0) @Max(59)
    private int initMinuteAfternoon;

    @Min(0) @Max(23)
    private int endHourAfternoon;

    @Min(0) @Max(59)
    private int endMinuteAfternoon;
}
