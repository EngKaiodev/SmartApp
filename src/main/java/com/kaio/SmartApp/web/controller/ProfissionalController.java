package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.DTO.profissional.response.ProfissionalDetailResponse;
import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.DTO.user.response.MyselfResponse;
import com.kaio.SmartApp.service.ProfissionalService;
import com.kaio.SmartApp.service.UserDetailImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    @GetMapping()
    public ResponseEntity<List<ProfissionalGetResponseDTO>> getAll(){
        List<ProfissionalGetResponseDTO> responseDTOs = profissionalService.getAll();
        return ResponseEntity.ok().body(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalDetailResponse> getDetail(@PathVariable("id") int id){
        return ResponseEntity.ok().body(profissionalService.getProDetail(id));
    }

    @GetMapping("/myself")
    public ResponseEntity<MyselfResponse> myself(@AuthenticationPrincipal UserDetailImpl userDetails){
        MyselfResponse response = profissionalService.getMyselfResponse(userDetails.getUsername());
        return ResponseEntity.ok(response);
    }

}
