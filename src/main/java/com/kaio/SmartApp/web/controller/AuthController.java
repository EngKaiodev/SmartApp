package com.kaio.SmartApp.web.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.DTO.AcessDTO;
import com.kaio.SmartApp.DTO.user.request.LoginRequestDTO;
import com.kaio.SmartApp.DTO.user.request.UserRequestDTO;
import com.kaio.SmartApp.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AcessDTO> login(@RequestBody LoginRequestDTO request) {
        AcessDTO response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<AcessDTO> register(@Valid @RequestBody UserRequestDTO request) {
        return ResponseEntity.ok(authService.register(request)); 
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");

        String newToken = authService.doRefresh(refreshToken);

        return ResponseEntity.ok(Map.of("token", newToken));
    }

}
