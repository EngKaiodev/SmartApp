package com.kaio.SmartApp.DTO.cliente.response;

import java.io.Serializable;
import java.util.List;

import com.kaio.SmartApp.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ClienteGetResponse implements Serializable {
    private int id_cliente;
    private String nome;
    private String email;
    private String telefone;
    private List<Endereco> enderecos;
}
