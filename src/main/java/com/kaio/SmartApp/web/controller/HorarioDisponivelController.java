package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kaio.SmartApp.DTO.horario_disponivel.request.HorarioDisponivelRequestDTO;
import com.kaio.SmartApp.DTO.horario_disponivel.response.HorarioDisponivelGetResponseDTO;
import com.kaio.SmartApp.service.HorarioDisponivelService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/Horarios")

public class HorarioDisponivelController {
    private final HorarioDisponivelService horarioDisponivelService;
    @GetMapping
    public ResponseEntity<List<HorarioDisponivelGetResponseDTO>> getAll(){
        List<HorarioDisponivelGetResponseDTO> response = horarioDisponivelService.SelectAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioDisponivelGetResponseDTO> getById(@PathVariable("id") int id) {
        HorarioDisponivelGetResponseDTO response = horarioDisponivelService.selectById(id);
        return ResponseEntity.ok().body(response);
    }
    
    /*@PostMapping()
    public ResponseEntity<HorarioDisponivelGetResponseDTO> insert(@RequestBody HorarioDisponivelRequestDTO horarioDisponivel){
        HorarioDisponivelGetResponseDTO response = horarioDisponivelService.save(horarioDisponivel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        horarioDisponivelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
