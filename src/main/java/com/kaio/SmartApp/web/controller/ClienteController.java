package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.entity.Cliente;
import com.kaio.SmartApp.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Clientes")
public class ClienteController {
    private final ClienteService clienteService;
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        List<Cliente> response= clienteService.SelectAll();
        return ResponseEntity.ok().body(response);
    }

}
