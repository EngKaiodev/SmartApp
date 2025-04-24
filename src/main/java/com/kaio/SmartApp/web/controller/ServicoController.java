package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.entity.Servico;
import com.kaio.SmartApp.service.ServicoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Servicos")

public class ServicoController {
    private final ServicoService servicoService;
    @GetMapping
    public ResponseEntity<List<Servico>> getAll(){
        List<Servico> response = servicoService.SelectAll();
        return ResponseEntity.ok().body(response);
    }

}
