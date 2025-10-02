package com.kaio.SmartApp.DTO.profissional.response;

import java.util.List;

import com.kaio.SmartApp.DTO.reviews.response.ReviewSimpleResponse;
import com.kaio.SmartApp.entity.Servicos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProfissionalDetailResponse {

    private ProfissionalGetResponseDTO profissional;
    private List<Servicos> servicos;
    private List<ReviewSimpleResponse> reviews;
}
