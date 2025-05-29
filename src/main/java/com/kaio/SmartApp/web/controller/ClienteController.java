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

import com.kaio.SmartApp.DTO.cliente.response.ClienteGetResponse;
import com.kaio.SmartApp.entity.Cliente;
import com.kaio.SmartApp.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteGetResponse>> getAll(){
        List<ClienteGetResponse> response = clienteService.SelectAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteGetResponse> getById(@PathVariable("id") int id){
        ClienteGetResponse response = clienteService.selectById(id);
        return ResponseEntity.ok().body(response); 
    }

    @PostMapping()
    public ResponseEntity<ClienteGetResponse> insert(@RequestBody Cliente cliente){
        Cliente response = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(response.toGetResponse());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
