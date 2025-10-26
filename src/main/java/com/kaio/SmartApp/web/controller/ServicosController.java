package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.DTO.servicos.request.ServicoEditRequest;
import com.kaio.SmartApp.DTO.servicos.request.ServicoRequest;
import com.kaio.SmartApp.DTO.servicos.response.IServiceCompleteResponse;
import com.kaio.SmartApp.DTO.servicos.response.ServicoResponse;
import com.kaio.SmartApp.service.ServicosService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/services")
public class ServicosController {

    private final ServicosService serviceService;

    @GetMapping
    public ResponseEntity<List<IServiceCompleteResponse>> getAll(){
        List<IServiceCompleteResponse> response = serviceService.SelectAll();        
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<ServicoResponse>> getAllByUserId(@PathVariable("id") int id){
        List<ServicoResponse> response = serviceService.getAllByProId(id);        
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponse> getById(int id){
        ServicoResponse response = serviceService.selectById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ServicoResponse> save(@RequestBody ServicoRequest request){
        ServicoResponse response = serviceService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/list")
    public ResponseEntity<List<ServicoResponse>> saveList(@RequestBody List<ServicoRequest> requestList){
        List<ServicoResponse> response = serviceService.saveList(requestList);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id){
        serviceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ServicoResponse> editService(@RequestBody ServicoEditRequest request){
        ServicoResponse response = serviceService.editService(request);
        return ResponseEntity.ok().body(response);
    }
}
