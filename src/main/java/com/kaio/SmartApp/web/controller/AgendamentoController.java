package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> getById(@PathVariable("id") int id){
        Agendamento response = agendamentoService.selectById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<Agendamento> insert(@RequestBody Agendamento agendamento){
        Agendamento response = agendamentoService.save(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
