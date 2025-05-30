package com.kaio.SmartApp.DTO.profissional.response;

import java.util.List;

import com.kaio.SmartApp.entity.Especialidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalGetResponseDTO {
    private int id_profissional;
    private String razao_social;
    private String contato;
    private String email;
    private List<Especialidade> especialidades;
}
