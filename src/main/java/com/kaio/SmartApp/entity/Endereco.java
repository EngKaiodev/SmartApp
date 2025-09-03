package com.kaio.SmartApp.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(
    name = "Enderecos",
    indexes = {
        @Index(name = "idx_endereco_cep", columnList = "cep")
    }
)
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String pais;
    @Column
    private String complemento;
    @Column(nullable = false)
    private String cep;

    @ManyToMany(mappedBy = "enderecos")
    @JsonBackReference
    private List<Cliente> clientes = new ArrayList<>();

    public Endereco(String rua, String numero, String bairro, String cidade, String pais, String complemento,
            String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.pais = pais;
        this.complemento = complemento;
        this.cep = cep;
    }
}
