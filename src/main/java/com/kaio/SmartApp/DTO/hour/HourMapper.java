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
            hours.getInitMinuteMorning(),
            hours.getEndHourMorning(), 
            hours.getEndMinuteMorning(),
            hours.getInitHourAfternoon(), 
            hours.getInitMinuteAfternoon(),
            hours.getEndHourAfternoon(),
            hours.getEndMinuteAfternoon()
        );
    }

    public static Hours toEntity(HourRequest request){
        Hours hours =  new Hours();
        hours.setUserId(request.getUserId());
        hours.setDay(request.getDay());

        hours.setInitHourMorning(request.getInitHourMorning());
        hours.setInitMinuteMorning(request.getInitMinuteMorning());

        hours.setInitHourAfternoon(request.getInitHourAfternoon());
        hours.setInitMinuteAfternoon(request.getInitMinuteAfternoon());

        hours.setEndHourMorning(request.getEndHourMorning());
        hours.setEndMinuteMorning(request.getEndMinuteMorning());

        hours.setEndHourAfternoon(request.getEndHourAfternoon());
        hours.setEndMinuteAfternoon(request.getEndMinuteAfternoon());
        return hours;
    }
}
