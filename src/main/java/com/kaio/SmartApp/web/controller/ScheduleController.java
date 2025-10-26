package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.DTO.schedule.request.ScheduleRequest;
import com.kaio.SmartApp.DTO.schedule.response.ScheduleResponse;
import com.kaio.SmartApp.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponse> save(@RequestBody ScheduleRequest request){
        ScheduleResponse response = scheduleService.saveEntity(request);
        return ResponseEntity.created(null).body(response);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ScheduleResponse>> getAllByUserId(@PathVariable("id") int id){
        List<ScheduleResponse> responses = scheduleService.getAllByUserId(id);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/pro/{id}")
    public ResponseEntity<List<ScheduleResponse>> getAllByProId(@PathVariable("id") int id){
        List<ScheduleResponse> responses = scheduleService.getAllByProId(id);
        return ResponseEntity.ok().body(responses);
    }

    @PostMapping("{id}/confirm")
    public ResponseEntity<Boolean> confirmScheduleById(@PathVariable("id") int id){
        Boolean response = scheduleService.confirmScheduleById(id);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("{id}/cancel")
    public ResponseEntity<Boolean> cancelScheduleById(@PathVariable("id") int id){
        Boolean response = scheduleService.cancelSchedule(id);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("{id}/review")
    public ResponseEntity<Boolean> reviewScheduleById(@PathVariable("id") int id){
        Boolean response = scheduleService.reviewSchedule(id);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("{id}/finish")
    public ResponseEntity<Boolean> finishScheduleById(@PathVariable("id") int id){
        Boolean response = scheduleService.finishSchedule(id);

        return ResponseEntity.ok().body(response);
    }
}
