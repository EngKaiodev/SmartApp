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

@Table(name = "Horarios")
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor


public class HorarioDisponivel implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_horario;
    @Column(nullable=false, unique=true, length=50) 
    private int id_profissional;
    @Column(nullable=false, unique=false, length=50) 
    private Date data;
    @Column(nullable=false, unique=true, length=50) 
    private Date hora_inicio;
    @Column(nullable=false, unique=true, length=50) 
    private Date hora_fim;
    @Column(nullable=false, unique=true, length=50) 
    private Status status;

    public enum Status{
        DISPONIVEL, BLOQUEADO, RESERVADO
    }

}

