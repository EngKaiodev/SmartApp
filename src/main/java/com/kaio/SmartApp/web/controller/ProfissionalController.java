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

import com.kaio.SmartApp.entity.Profissional;
import com.kaio.SmartApp.service.ProfissionalService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Profissionais")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    @GetMapping()
    public ResponseEntity<List<Profissional>> getAll() {
        List<Profissional> response = profissionalService.SelectAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getById(@PathVariable int id){
        Profissional response = profissionalService.selectById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<Profissional> insert(@RequestBody Profissional profissional) {
        Profissional response = profissionalService.save(profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        profissionalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
