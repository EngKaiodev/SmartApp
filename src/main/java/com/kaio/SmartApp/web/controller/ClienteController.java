package com.kaio.SmartApp.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.DTO.user.request.UserEditRequest;
import com.kaio.SmartApp.DTO.user.response.MyselfResponse;
import com.kaio.SmartApp.service.ClienteService;
import com.kaio.SmartApp.service.UserDetailImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping("/myself")
    public ResponseEntity<MyselfResponse> myself(@AuthenticationPrincipal UserDetailImpl userDetails){
        MyselfResponse response = clienteService.mySelf(userDetails.getUsername());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/myself")
    public ResponseEntity<MyselfResponse> editMyself(@Valid @RequestBody UserEditRequest edited, @AuthenticationPrincipal UserDetailImpl user){
        MyselfResponse response = clienteService.editMyself(edited, user.getUsername());
        return ResponseEntity.ok(response);
    }
}
