package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.entity.Agendamento;
import com.kaio.SmartApp.service.AgendamentoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Agendamentos")

public class AgendamentoController {
    private final AgendamentoService agendamentoService;
    @GetMapping
    public ResponseEntity<List<Agendamento>> getAll(){
        List<Agendamento> response = agendamentoService.SelectAll();
        return ResponseEntity.ok().body(response);
    }


}
