package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.address.request.AddressEditRequest;
import com.kaio.SmartApp.DTO.address.response.AddressResponse;
import com.kaio.SmartApp.DTO.profissional.response.ProfissionalDetailResponse;
import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;
import com.kaio.SmartApp.DTO.reviews.response.ReviewSimpleResponse;
import com.kaio.SmartApp.DTO.servicos.response.ServicoResponse;
import com.kaio.SmartApp.DTO.user.UserMapper;
import com.kaio.SmartApp.DTO.user.request.UserEditRequest;
import com.kaio.SmartApp.DTO.user.response.MyselfResponse;
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
    private final AddressService addressService;

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

        List<ServicoResponse> servicos = servicosService.getAllByProId(id);

        List<ReviewSimpleResponse> reviews = reviewService.getLast3byId(id);

        AddressResponse address = addressService.getEntityByUserId(id);

            return new ProfissionalDetailResponse(proResponse, servicos, reviews, address);
    }

    @Transactional(readOnly = true)
    public UserModel getEntityByEmail(String email){
        return profissionalRepository.findByEmail(email).orElseThrow(
            () -> new EntityNotFoundException("Usuário com email " + email + " não encontrado.")
        );
    }

    public MyselfResponse getMyselfResponse(String email){
        UserModel user = getEntityByEmail(email);
        AddressResponse address = addressService.getEntityByUserId(user.getId());
        return UserMapper.toMyselfResponse(user, address);
    }

    public MyselfResponse editMyself(UserEditRequest request, String email){
        UserModel user = getEntityByEmail(email);

        UserMapper.upgradeWithEditRequest(user, request);

        user = profissionalRepository.save(user);

        addressService.editAddress(
            new AddressEditRequest(user.getId(), request.getZipcode(), request.getAddress(), request.getNumber())
        );

        return getMyselfResponse(email);
    }
}
