package com.kaio.SmartApp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

@Table(name="Profissionais")
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Profissional implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_profissional;
    @Column(nullable=false, unique=true, length=50) 
    private String razao_social;
    @Column(nullable=false, unique=true, length=100) 
    private String contato;
    @Column(nullable=false, unique=false, length=100) 
    private String email;
    @Column(nullable=false, unique=false, length=100) 
    private String senha;
    @Column(nullable=false, unique=true, length=100) 
    private String cnpj;
    @Column(nullable=false, unique=true, length=100) 
    private String especialidades;

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.REMOVE, orphanRemoval = false)
    @JsonBackReference
    private List<Servico> servicos = new ArrayList<>();
    
}
