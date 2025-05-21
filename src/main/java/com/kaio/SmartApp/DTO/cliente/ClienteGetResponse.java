package com.kaio.SmartApp.DTO.cliente;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ClienteGetResponse implements Serializable {
    private int id_cliente;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
}
