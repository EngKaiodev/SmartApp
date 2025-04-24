package com.kaio.SmartApp.entity;

import java.io.Serializable;
import java.util.Date;

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

@Table(name="Notificacoes")
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Notificacao implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_notificacao;
    @Column(nullable=false, unique=true, length=50) 
    private int id_agendamento;
    @Column(nullable=false, unique=false, length=10000) 
    private String mensagem;
    @Column(nullable=false, unique=false, length=50) 
    private Date data_envio;
}
