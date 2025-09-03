package com.kaio.SmartApp.DTO.servico.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoRequestDTO {
    private Integer id_profissional;
    private String nome;
    private String descricao;
    private float preco;
    private int duracao;

}
