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

@Table(name="Agendamentos")
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Agendamento implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_agendamento;
    @Column(nullable=false, unique=false, length=50)
    private int id_cliente;
    @Column(nullable=false, unique=false, length=50)
    private int id_profissional;
    @Column(nullable=false, unique=false, length=50)
    private int id_servico;
    @Column(nullable=false, unique=false, length=50)
    private Date data_hora;
    @Column(nullable=false, unique=true, length=50)
    private StatusAgendamento statusAgendamento;
    @Column(nullable=false, unique=true, length=50)
    private int nota;
    @Column(nullable=false, unique=true, length=50)
    private String comentario;
    @Column(nullable=false, unique=false, length=50)
    private Date data_hora_criacao;

   public enum StatusAgendamento{
     PENDENTE, CONFIRMADO, CANCELADO, REAGENDADO
   }
}
