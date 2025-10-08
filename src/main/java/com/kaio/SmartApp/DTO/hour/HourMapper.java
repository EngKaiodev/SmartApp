package com.kaio.SmartApp.DTO.hour;

import com.kaio.SmartApp.DTO.hour.request.HourRequest;
import com.kaio.SmartApp.DTO.hour.response.HourResponse;
import com.kaio.SmartApp.entity.Hours;

public class HourMapper {
    public static HourResponse toResponse(Hours hours){
        return new HourResponse(
            hours.getId(), 
            hours.getDay(), 
            hours.getInitHourMorning(), 
            hours.getEndHourMorning(), 
            hours.getInitHourAfternoon(), 
            hours.getEndHourAfternoon()
        );
    }

    public static Hours toEntity(HourRequest request){
        Hours hours =  new Hours();
        hours.setUserId(request.getUserId());
        hours.setDay(request.getDay());
        hours.setInitHourMorning(request.getInitHourMorning());
        hours.setInitHourAfternoon(request.getInitHourAfternoon());
        hours.setEndHourMorning(request.getEndHourMorning());
        hours.setEndHourAfternoon(request.getEndHourAfternoon());
        return hours;
    }
}
