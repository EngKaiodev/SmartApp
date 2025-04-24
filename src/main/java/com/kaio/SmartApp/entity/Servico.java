package com.kaio.SmartApp.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Servicos")
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Servico implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_servico;
    @Column(nullable=false, unique=true, length=50) 
    private int id_profissional;
    @Column(nullable=false, unique=false, length=50) 
    private String nome_servico;
    @Column(nullable=false, unique=false, length=50) 
    private String descricao;
    @Column(nullable=false, unique=false, length=50) 
    private float preco;
    @Column(nullable=false, unique=true, length=50) 
    private int duracao;
    
}
