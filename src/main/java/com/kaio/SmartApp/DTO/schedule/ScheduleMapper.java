package com.kaio.SmartApp.DTO.schedule;

import com.kaio.SmartApp.DTO.hour.response.HourResponse;
import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.DTO.schedule.request.ScheduleRequest;
import com.kaio.SmartApp.DTO.schedule.response.ScheduleResponse;
import com.kaio.SmartApp.DTO.servicos.response.ServicoResponse;
import com.kaio.SmartApp.entity.Schedule;

public class ScheduleMapper {

    public static Schedule toEntity(ScheduleRequest request){
        return new Schedule(
            0, 
            request.getUserId(), 
            request.getProId(),
            request.getServiceId(),
            request.getHourId(),
            0);
    }

    public static ScheduleResponse toResponse(Schedule schedule, ProfissionalGetResponseDTO pro, ServicoResponse servico, HourResponse hour){
        ScheduleResponse response = new ScheduleResponse();
        response.setId(schedule.getId());
        response.setProfissional(pro);
        response.setServico(servico);
        response.setHour(hour);
        response.setStatus(schedule.getStatus());

        return response;
    }
}
