package com.kaio.SmartApp.DTO.servico.response;

import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoGetRespondeDTO {
    private Integer id_servico;
    private ProfissionalGetResponseDTO profissional;
    private String nome;
    private String descricao;
    private float preco;
    private int duracao;
}
