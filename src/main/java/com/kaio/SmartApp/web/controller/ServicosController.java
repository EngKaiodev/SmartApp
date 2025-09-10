package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.entity.Servicos;
import com.kaio.SmartApp.service.ServicosService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Servicos")
public class ServicosController {

    private final ServicosService serviceService;

    @GetMapping
    public ResponseEntity<List<Servicos>> getAll(){
        List<Servicos> response = serviceService.SelectAll();        
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicos> getById(int id){
        Servicos response = serviceService.selectById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Servicos> save(@RequestBody Servicos servicos){
        Servicos response = serviceService.save(servicos);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id){
        serviceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
