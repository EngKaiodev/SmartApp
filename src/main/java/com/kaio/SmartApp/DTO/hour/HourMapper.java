package com.kaio.SmartApp.DTO.hour;

import com.kaio.SmartApp.DTO.hour.request.HourRequest;
import com.kaio.SmartApp.DTO.hour.response.HourResponse;
import com.kaio.SmartApp.entity.Hours;

public class HourMapper {
    public static HourResponse toResponse(Hours hours){
        return new HourResponse(
            hours.getId(), 
            hours.getInitHour(),
            hours.getEndHour(),
            hours.getStatus()
        );
    }

    public static Hours toEntity(HourRequest request){
        Hours hours =  new Hours();
        hours.setUserId(request.getUserId());
        hours.setInitHour(request.getInitHour());
        hours.setEndHour(request.getEndHour());
        hours.setStatus(request.getStatus());
        return hours;
    }

    public static void update(Hours old, HourRequest request){
        old.setInitHour(request.getInitHour());
        old.setEndHour(request.getEndHour());
    }
}
