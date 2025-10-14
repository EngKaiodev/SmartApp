package com.kaio.SmartApp.DTO.hour.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HourResponse {
    private int id;
    private int day; //1 a 7 começando na segunda e terminando no domingo.
    
    private int initHourMorning;
    private int initMinuteMorning;

    private int endHourMorning;
    private int endMinuteMorning;

    private int initHourAfternoon;
    private int initMinuteAfternoon;
    
    private int endHourAfternoon;
    private int endMinuteAfternoon;
}
