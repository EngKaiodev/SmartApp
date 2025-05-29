package com.kaio.SmartApp.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kaio.SmartApp.DTO.cliente.ClienteGetResponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Clientes")
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_cliente;
    @Column(nullable=false, unique=true, length=50) 
    private String nome;
    @Column(nullable=false, unique=true, length=100) 
    private String email;
    @Column(nullable=false, unique=true, length=50) 
    private String telefone;
    @Column(nullable=false, unique=false, length=50) 
    private String senha; 
    @Column(nullable=false, unique=true, length=50) 
    private String cpf_cnpj;
    @Column(nullable=false, unique=false, length=50) 
    private String endereco;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.REMOVE, orphanRemoval = false)
    @JsonBackReference
    private List<Agendamento> Agendamentos = new ArrayList<>();

    public ClienteGetResponse toGetResponse(){
        return new ClienteGetResponse(
            id_cliente,
            nome,
            email,
            telefone,
            endereco
        );
    }

}

