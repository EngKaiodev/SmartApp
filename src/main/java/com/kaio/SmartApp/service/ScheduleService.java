package com.kaio.SmartApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.hour.response.HourResponse;
import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.DTO.schedule.ScheduleMapper;
import com.kaio.SmartApp.DTO.schedule.request.ScheduleRequest;
import com.kaio.SmartApp.DTO.schedule.response.ScheduleResponse;
import com.kaio.SmartApp.DTO.servicos.response.ServicoResponse;
import com.kaio.SmartApp.entity.Schedule;
import com.kaio.SmartApp.repository.ScheduleRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ProfissionalService profissionalService;
    private final ServicosService servicesService;
    private final HourService hourService;

    @Transactional(readOnly = false)
    public ScheduleResponse saveEntity(ScheduleRequest request) {
        ProfissionalGetResponseDTO pro = profissionalService.getPro(request.getProId());
        ServicoResponse servico = servicesService.selectById(request.getServiceId());
        HourResponse hour = hourService.getById(request.getHourId());

        Schedule response = ScheduleMapper.toEntity(request);

        response.setStatus(0);

        response = scheduleRepository.save(response);

        return ScheduleMapper.toResponse(response, pro, servico, hour);
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> getAllByUserId(int id) {
        List<ScheduleResponse> responses = new ArrayList<>();
        List<Schedule> schedules = scheduleRepository.findAllByUserId(id);

        for (int i = 0; i < schedules.size(); i++) {
            Schedule item = schedules.get(i);

            ProfissionalGetResponseDTO pro = profissionalService.getPro(item.getProId());
            ServicoResponse servico = servicesService.selectById(item.getServiceId());
            HourResponse hour = hourService.getById(item.getHourId());

            responses.add(ScheduleMapper.toResponse(item, pro, servico, hour));
        }

        return responses;
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> getAllByProId(int id) {
        List<ScheduleResponse> responses = new ArrayList<>();
        List<Schedule> schedules = scheduleRepository.findAllByProId(id);

        for (int i = 0; i < schedules.size(); i++) {
            Schedule item = schedules.get(i);

            ProfissionalGetResponseDTO pro = profissionalService.getPro(item.getProId());
            ServicoResponse servico = servicesService.selectById(item.getServiceId());
            HourResponse hour = hourService.getById(item.getHourId());

            responses.add(ScheduleMapper.toResponse(item, pro, servico, hour));
        }

        return responses;
    }

    @Transactional(readOnly = true)
    public Schedule getEntityById(int id){
        return scheduleRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Agendamento com id " + id + " não encontrado.")
        );
    }

    @Transactional(readOnly = false)
    public boolean confirmScheduleById(int id){
        Schedule schedule = getEntityById(id);

        if (schedule.getStatus() == 0) {
            schedule.setStatus(1);
        }

        scheduleRepository.save(schedule);

        return true;
    }

    @Transactional(readOnly = false)
    public boolean cancelSchedule(int id){
        Schedule schedule = getEntityById(id);

        schedule.setStatus(2);

        hourService.updateStatusById(schedule.getHourId(), "opened");

        scheduleRepository.save(schedule);

        return true;
    }
}
