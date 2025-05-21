package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kaio.SmartApp.entity.HorarioDisponivel;
import com.kaio.SmartApp.service.HorarioDisponivelService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/{id}")
    public ResponseEntity<HorarioDisponivel> getById(@PathVariable("id") int id) {
        HorarioDisponivel response = horarioDisponivelService.selectById(id);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping()
    public ResponseEntity<HorarioDisponivel> insert(@RequestBody HorarioDisponivel horarioDisponivel){
        HorarioDisponivel response = horarioDisponivelService.save(horarioDisponivel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        horarioDisponivelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
