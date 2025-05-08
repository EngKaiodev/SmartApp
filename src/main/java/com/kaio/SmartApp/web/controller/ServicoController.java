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

    @GetMapping("/id")
    public ResponseEntity<Servico> getById(@PathVariable int id){
        Servico response = servicoService.selectById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<Servico> insert(@RequestBody Servico servico){
        Servico response = servicoService.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable int id){
        servicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
