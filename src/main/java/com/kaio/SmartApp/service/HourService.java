package com.kaio.SmartApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.hour.HourMapper;
import com.kaio.SmartApp.DTO.hour.request.HourRequest;
import com.kaio.SmartApp.DTO.hour.response.HourResponse;
import com.kaio.SmartApp.entity.Hours;
import com.kaio.SmartApp.repository.HourRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HourService {

    private final HourRepository repository;

    @Transactional(readOnly = false)
    public HourResponse save(HourRequest hour){
        Hours toSave = HourMapper.toEntity(hour);
        return HourMapper.toResponse(toSave);
    }

    @Transactional(readOnly = true)
    private Hours getEntityById(int id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Horário com id " + id + " não encontrado")
        );
    }

    @Transactional(readOnly = true)
    public List<Hours> getEntityByUserId(int id){
        return repository.findAllByUserId(id);
    }

    @Transactional
    public List<HourResponse> saveOrUpdateAll(List<HourRequest> hoursList) {
        List<Hours> result = new ArrayList<>();

        for (HourRequest hour : hoursList) {
            Hours existing = repository.findByUserIdAndDay(hour.getUserId(), hour.getDay()).orElse(null);

            if (existing != null) {
                Hours entity = existing;

                entity.setInitHourMorning(hour.getInitHourMorning());
                entity.setInitMinuteMorning(hour.getInitMinuteMorning());
                entity.setEndHourMorning(hour.getEndHourMorning());
                entity.setEndMinuteMorning(hour.getEndMinuteMorning());
                entity.setInitHourAfternoon(hour.getInitHourAfternoon());
                entity.setInitMinuteAfternoon(hour.getInitMinuteAfternoon());
                entity.setEndHourAfternoon(hour.getEndHourAfternoon());
                entity.setEndMinuteAfternoon(hour.getEndMinuteAfternoon());

                result.add(entity);
            } else {
                result.add(HourMapper.toEntity(hour));
            }
        }

        List<Hours> response = repository.saveAll(result);

        return response.stream().map(HourMapper::toResponse).toList();
    }

}
