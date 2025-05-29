package com.kaio.SmartApp.DTO.servico.request;

import com.kaio.SmartApp.entity.Profissional;
import com.kaio.SmartApp.entity.Servico;

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

    public Servico toEntity(Profissional profissional){
        return new Servico(
            profissional,
            getNome(),
            getDescricao(),
            getPreco(),
            getDuracao()
        );
    }
}
