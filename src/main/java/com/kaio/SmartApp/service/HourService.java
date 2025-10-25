package com.kaio.SmartApp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
    public HourResponse save(HourRequest hour) {
        Hours toSave = HourMapper.toEntity(hour);
        return HourMapper.toResponse(toSave);
    }

    @Transactional
    public List<HourResponse> saveOrUpdateList(List<HourRequest> hoursList) {
        if (hoursList == null || hoursList.isEmpty()) {
            throw new IllegalArgumentException("Lista de horários vazia.");
        }

        int userId = hoursList.get(0).getUserId();
        List<Hours> finalResult = new ArrayList<>();

        Map<LocalDate, List<HourRequest>> groupedByDate = hoursList.stream()
                .collect(Collectors.groupingBy(h -> h.getInitHour().toLocalDate()));

        for (Map.Entry<LocalDate, List<HourRequest>> entry : groupedByDate.entrySet()) {
            LocalDate date = entry.getKey();

            if (date.equals(LocalDate.now())) {
                throw new IllegalArgumentException("Não é possível alterar horários do dia atual (" + date + ").");
            }

            List<HourRequest> listForDate = entry.getValue();

            List<Hours> existingList = repository.findAllByUserIdAndDateAndStatus(userId, date, "opened");

            List<Hours> newList = listForDate.stream()
                    .map(HourMapper::toEntity)
                    .toList();

            Map<LocalDateTime, Hours> newMap = newList.stream()
                    .collect(Collectors.toMap(Hours::getInitHour, h -> h));

            List<Hours> toRemove = existingList.stream()
                    .filter(existing -> !newMap.containsKey(existing.getInitHour()))
                    .toList();

            if (!toRemove.isEmpty()) {
                repository.deleteAll(toRemove);
            }

            Set<LocalDateTime> existingHours = existingList.stream()
                    .map(Hours::getInitHour)
                    .collect(Collectors.toSet());

            List<Hours> toAdd = newList.stream()
                    .filter(newHour -> !existingHours.contains(newHour.getInitHour()))
                    .toList();

            if (!toAdd.isEmpty()) {
                repository.saveAll(toAdd);
            }

            finalResult.addAll(repository.findAllByUserIdAndDateAndStatus(userId, date, "opened"));
        }

        return finalResult.stream()
                .map(HourMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    private Hours getEntityById(int id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Horário com id " + id + " não encontrado"));
    }

    public HourResponse getById(int id){
        return HourMapper.toResponse(getEntityById(id));
    }

    @Transactional(readOnly = true)
    public List<Hours> getEntityListByUserIdAndDateAndStatus(int id, LocalDate date, String status) {
        return repository.findAllByUserIdAndDateAndStatus(id, date, status);
    }

    public List<HourResponse> getAllByUserIdAndDateAndStatus(int id, LocalDate date, String status) {
        List<Hours> responses = getEntityListByUserIdAndDateAndStatus(id, date, status);

        return responses.stream().map(HourMapper::toResponse).toList();
    }

    @Transactional(readOnly = false)
    public HourResponse updateStatusById(int id, String status){
        Hours hour = getEntityById(id);

        hour.setStatus(status);

        hour = repository.save(hour);

        return HourMapper.toResponse(hour);
    }

}
