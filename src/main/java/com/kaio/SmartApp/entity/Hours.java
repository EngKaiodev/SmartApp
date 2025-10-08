package com.kaio.SmartApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "hours")
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Hours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int day; // 1 = segunda ... 7 = domingo
    private int initHourMorning;
    private int initMinuteMorning;
    private int endHourMorning;
    private int endMinuteMorning;
    private int initHourAfternoon;
    private int initMinuteAfternoon;
    private int endHourAfternoon;
    private int endMinuteAfternoon;
}
