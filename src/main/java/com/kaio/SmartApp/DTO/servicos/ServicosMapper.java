package com.kaio.SmartApp.DTO.servicos;

import com.kaio.SmartApp.DTO.servicos.request.ServicoEditRequest;
import com.kaio.SmartApp.DTO.servicos.request.ServicoRequest;
import com.kaio.SmartApp.DTO.servicos.response.ServicoResponse;
import com.kaio.SmartApp.entity.Servicos;

public class ServicosMapper {
    public static Servicos toEntity(ServicoRequest request){
        Servicos response = new Servicos();

        response.setName(request.getName());
        response.setDescription(request.getDescription());
        response.setDuration(request.getDuration());
        response.setPrice(request.getPrice());
        response.setProId(request.getProId());

        return response;
    }

    public static ServicoResponse toResponse(Servicos model){
        return new ServicoResponse(
            model.getId(),
            model.getName(), 
            model.getDescription(), 
            model.getPrice(), 
            model.getDuration()
            );
    }

    public static void update(Servicos old, ServicoEditRequest newRequest){
        old.setName(newRequest.getName());
        old.setDescription(newRequest.getDescription());
        old.setPrice(newRequest.getPrice());
        old.setDuration(newRequest.getDuration());
    }
}
