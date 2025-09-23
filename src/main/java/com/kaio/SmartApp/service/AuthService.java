package com.kaio.SmartApp.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kaio.SmartApp.DTO.AcessDTO;
import com.kaio.SmartApp.DTO.user.request.LoginRequestDTO;
import com.kaio.SmartApp.DTO.user.request.UserRequestDTO;
import com.kaio.SmartApp.entity.UserModel;
import com.kaio.SmartApp.security.jwl.JwtUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    public AcessDTO login(LoginRequestDTO request) {
        try {
            UsernamePasswordAuthenticationToken authInput = new UsernamePasswordAuthenticationToken(
                    request.getEmail(), request.getPassword());

            Authentication auth = authenticationManager.authenticate(authInput);

            UserDetailImpl user = (UserDetailImpl) auth.getPrincipal();
            String token = jwtUtils.generationTokenFromUserDetailsImpl(user);
            String refreshToken = jwtUtils.generateRefreshToken(user.getUsername());
            UserModel model = userService.getEntityByEmail(request.getEmail());
            
            return new AcessDTO(model.getId(), token, refreshToken, model.getType());

        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao realizar login.");
        }
    }

    public String doRefresh(String refreshToken){
        if (refreshToken == null || !jwtUtils.validateJwtToken(refreshToken)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Refresh token inválido");
        }

        String username = jwtUtils.getUserNameToken(refreshToken);
        UserModel user = userService.getEntityByEmail(username);
        String newToken = jwtUtils.generationTokenFromUserDetailsImpl(
                UserDetailImpl.build(user)
        );

        return newToken;
    }

    public AcessDTO register(UserRequestDTO request){
        String rawPassword = request.getPassword();
        UserModel newUser = userService.save(request);
        return login(new LoginRequestDTO(newUser.getEmail(), rawPassword));
    }

}
