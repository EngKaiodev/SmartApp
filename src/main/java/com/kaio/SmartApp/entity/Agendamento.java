package com.kaio.SmartApp.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico servico;
    @Column(nullable=false, unique=false, length=50)
    private LocalDateTime data_hora;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false, unique=true, length=50)
    private StatusAgendamento status;
    @Column(nullable=false, unique=true, length=50)
    private int nota;
    @Column(nullable=false, unique=true, length=50)
    private String comentario;
    @Column(nullable=false, unique=false, length=50)
    private LocalDateTime data_hora_criacao;

   public enum StatusAgendamento{
     PENDENTE, CONFIRMADO, CANCELADO, REAGENDADO
   }
}
