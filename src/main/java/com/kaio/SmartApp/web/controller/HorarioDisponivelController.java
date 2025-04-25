package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.entity.HorarioDisponivel;
import com.kaio.SmartApp.service.HorarioDisponivelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Horarios")

public class HorarioDisponivelController {
    private final HorarioDisponivelService horarioDisponivelService;
    @GetMapping
    public ResponseEntity<List<HorarioDisponivel>> getAll(){
        List<HorarioDisponivel> response = horarioDisponivelService.SelectAll();
        return ResponseEntity.ok().body(response);
    }

}
