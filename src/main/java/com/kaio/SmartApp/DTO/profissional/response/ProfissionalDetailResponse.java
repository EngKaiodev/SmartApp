package com.kaio.SmartApp.DTO.profissional.response;

import java.util.List;

import com.kaio.SmartApp.DTO.address.response.AddressResponse;
import com.kaio.SmartApp.DTO.reviews.interfaceProjection.IReviewSimpleResponse;
import com.kaio.SmartApp.DTO.servicos.response.ServicoResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProfissionalDetailResponse {

    private ProfissionalGetResponseDTO profissional;
    private List<ServicoResponse> servicos;
    private List<IReviewSimpleResponse> reviews;
    private AddressResponse address;
}
