package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaio.SmartApp.DTO.hour.request.HourRequest;
import com.kaio.SmartApp.DTO.hour.response.HourResponse;
import com.kaio.SmartApp.service.HourService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Validated
@RequestMapping("/hour")
@Controller
public class HourController {
    private final HourService service;

    @PostMapping
    public ResponseEntity<HourResponse> save(@Valid @RequestBody HourRequest hours) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(hours));
    }

    @PostMapping("/list")
    public ResponseEntity<List<HourResponse>> saveList(
            @Valid @RequestBody List<HourRequest> list) {
        
                List<HourResponse> responses = service.saveOrUpdateAll(list);

        return ResponseEntity.ok(responses);
    }
}
