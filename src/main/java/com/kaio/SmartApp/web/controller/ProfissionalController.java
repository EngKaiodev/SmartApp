package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.service.ProfissionalService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Profissionais")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    @GetMapping()
    public ResponseEntity<List<ProfissionalGetResponseDTO>> getAll() {
        List<ProfissionalGetResponseDTO> response = profissionalService.getAll();
        return ResponseEntity.ok().body(response);
    }
}
