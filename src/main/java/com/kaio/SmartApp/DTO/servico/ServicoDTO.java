package com.kaio.SmartApp.DTO.servico;

import com.kaio.SmartApp.entity.Profissional;
import com.kaio.SmartApp.entity.Servico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {
    private Integer id_servico;
    private Integer id_profissional;
    private String nome_servico;
    private String descricao;
    private float preco;
    private int duracao;

    public Servico toEntity(Profissional profissional){
        return new Servico(
            profissional,
            getNome_servico(),
            getDescricao(),
            getPreco(),
            getDuracao()
        );
    }
}
