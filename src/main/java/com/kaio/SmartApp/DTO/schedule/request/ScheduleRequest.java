package com.kaio.SmartApp.DTO.schedule.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ScheduleRequest {
    private int userId;
    private int proId;
    private int serviceId;
    private int hourId;
}
