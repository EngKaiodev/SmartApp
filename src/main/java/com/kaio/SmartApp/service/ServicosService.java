package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kaio.SmartApp.DTO.servicos.ServicosMapper;
import com.kaio.SmartApp.DTO.servicos.request.ServicoEditRequest;
import com.kaio.SmartApp.DTO.servicos.request.ServicoRequest;
import com.kaio.SmartApp.DTO.servicos.response.ServicoResponse;
import com.kaio.SmartApp.entity.Servicos;
import com.kaio.SmartApp.repository.ServicosRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServicosService {

    private final ServicosRepository servicosRepository;

    @Transactional(readOnly = true)
    public List<ServicoResponse> SelectAll() {
        List<ServicoResponse> rList = servicosRepository
                                .findAll()
                                .stream()
                                .map(ServicosMapper::toResponse)
                                .toList();
        return rList;
    }

    @Transactional(readOnly = true)
    public ServicoResponse selectById(int id) {
        return ServicosMapper.toResponse(selectEntityById(id));
    }

    @Transactional(readOnly = true)
    public Servicos selectEntityById(int id) {
        return servicosRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Serviço com id " + id + " não encontrado"));
    }

    @Transactional
    public ServicoResponse save(ServicoRequest request) {
        Servicos response = servicosRepository.save(ServicosMapper.toEntity(request));
        return ServicosMapper.toResponse(response);
    }

    @Transactional
    public List<ServicoResponse> saveList(List<ServicoRequest> requestList){
        List<Servicos> toSave = requestList.stream().map(ServicosMapper::toEntity).toList();
        List<Servicos> response = servicosRepository.saveAll(toSave);
        return response.stream().map(ServicosMapper::toResponse).toList();
    }

    @Transactional
    public void deleteById(int id) {
        servicosRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ServicoResponse> getAllByProId(int id){
        List<Servicos> response = servicosRepository.findAllByProId(id);
        return response.stream().map(ServicosMapper::toResponse).toList();
    }

    public ServicoResponse editService(ServicoEditRequest request) {
        Servicos existing = selectEntityById(request.getId());

        ServicosMapper.update(existing, request);

        existing = servicosRepository.save(existing);

        return ServicosMapper.toResponse(existing);
    }
}
