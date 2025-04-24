package com.kaio.SmartApp.web.controller;


import java.util.List;

import arg.apache.catalina.connector.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.entity.Profissional;
import com.kaio.SmartApp.service.ProfissionalService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Profissionais")

public class ProfissionalController {
    private final ProfissionalService profissionalService;
    @GetMapping
    public ResponseEntity<List<Profissional>> getAll(){
        List<Profissional> response = profissionalService.SelectAll();
        return ResponseEntity.ok().body(response);
    }

}
