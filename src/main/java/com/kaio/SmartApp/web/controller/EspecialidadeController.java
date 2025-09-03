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
import com.kaio.SmartApp.service.EspecialidadeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Especialidades")
public class EspecialidadeController {
    private final EspecialidadeService especialidadeService;

    @PostMapping
    public ResponseEntity<Servicos> insert(@RequestBody Servicos especialidade) {
        Servicos response = especialidadeService.save(especialidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Servicos>> getAll(){
        List<Servicos> response = especialidadeService.selectAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicos> getById(@PathVariable("id") int id){
        Servicos response = especialidadeService.selectById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        especialidadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
