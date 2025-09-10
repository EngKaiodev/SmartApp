package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.cliente.ClienteMapper;
import com.kaio.SmartApp.DTO.profissional.ProfissionalMapper;
import com.kaio.SmartApp.DTO.user.UserMapper;
import com.kaio.SmartApp.DTO.user.request.UserRequestDTO;
import com.kaio.SmartApp.DTO.user.response.UserResponseDTO;
import com.kaio.SmartApp.entity.UserModel;
import com.kaio.SmartApp.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProfissionalService profissionalService;
    private final ClienteService clienteService;

    @Transactional(readOnly = true)
    public UserModel selectEntityById(int id){
        return userRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Usuário com id " + id + " não encontrado.")
        );
    }

    @Transactional(readOnly = true)
    public UserResponseDTO selectById(int id){
        return UserMapper.toResponse(selectEntityById(id));
    }

    @Transactional(readOnly = true)
    public List<UserResponseDTO> selectAll(){
        List<UserModel> response = userRepository.findAll();

        return response.stream().map(UserMapper::toResponse).toList();
    }

    @Transactional
    public UserResponseDTO save(UserRequestDTO request){
        request.setPassword(passwordEncoder.encode(request.getPassword()));

        switch (request.getType()) {
            case 1:
                profissionalService.save(ProfissionalMapper.userToProfissional(request));
                break;
            case 2:
                clienteService.save(ClienteMapper.userToCliente(request));
        
            default:
                break;
        }

        UserModel response = saveEntity(UserMapper.toEntity(request));
        return UserMapper.toResponse(response);
    }

    @Transactional
    public UserModel saveEntity(UserModel model){
        return userRepository.save(model);
    }

    @Transactional
    public UserResponseDTO update(int id, UserRequestDTO updatedUser){
        UserModel existingUser = selectEntityById(id);

        UserMapper.upgrade(existingUser, updatedUser);

        existingUser = saveEntity(existingUser);

        return UserMapper.toResponse(existingUser);
    }

    @Transactional
    public UserResponseDTO deleteById(int id){
        UserModel entity = selectEntityById(id);
        userRepository.deleteById(id);
        return UserMapper.toResponse(entity);
    }

}
