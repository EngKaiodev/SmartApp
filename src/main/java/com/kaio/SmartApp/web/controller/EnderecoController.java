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

import com.kaio.SmartApp.entity.Endereco;
import com.kaio.SmartApp.service.EnderecoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Enderecos")
public class EnderecoController {
    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco){
        Endereco response = enderecoService.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAll(){
        List<Endereco> response = enderecoService.selectAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getById(@PathVariable("id") int id){
        Endereco response = enderecoService.selectById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable("id") int id){
        enderecoService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

}
