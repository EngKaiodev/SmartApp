package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.profissional.response.ProfissionalDetailResponse;
import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.DTO.user.UserMapper;
import com.kaio.SmartApp.entity.Servicos;
import com.kaio.SmartApp.entity.UserModel;
import com.kaio.SmartApp.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfissionalService {

    private final UserRepository profissionalRepository;
    private final ServicosService servicosService;
    private final ReviewService reviewService;

    @Transactional(readOnly = true)
    public List<ProfissionalGetResponseDTO> getAll(){
        List<Object[]> models = profissionalRepository.findPros();
        List<ProfissionalGetResponseDTO> response = models.stream()
        .map(UserMapper::toProResponse)
        .toList();
        return response;
    }

    @Transactional(readOnly = true)
    public ProfissionalDetailResponse getProDetail(int id){
        List<Object[]> obj = profissionalRepository.findOneById(id);
        ProfissionalGetResponseDTO proResponse = UserMapper.toProResponse(obj.get(0));

        List<Servicos> servicos = servicosService.getAllByProId(proResponse.getId());

            return new ProfissionalDetailResponse(proResponse, servicos);
    }
}
