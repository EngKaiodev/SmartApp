package com.kaio.SmartApp.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kaio.SmartApp.DTO.horario_disponivel.response.HorarioDisponivelGetResponseDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private Profissional profissional;
    @Column(nullable=false, unique=false, length=50) 
    private LocalDate data;
    @Column(nullable=false, unique=true, length=50) 
    private LocalTime hora_inicio;
    @Column(nullable=false, unique=true, length=50) 
    private LocalTime hora_fim;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false, unique=true, length=50) 
    private Status status;

    @OneToMany(mappedBy = "horarioDisponivel", cascade = CascadeType.REMOVE, orphanRemoval = false)
    @JsonBackReference
    private List<Agendamento> agendamentos = new ArrayList<>();

    public enum Status{
        DISPONIVEL, BLOQUEADO, RESERVADO
    }

    public HorarioDisponivel(Profissional profissional, LocalDate data, LocalTime hora_inicio, LocalTime hora_fim,
            Status status) {
        this.profissional = profissional;
        this.data = data;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.status = status;
    }

    public HorarioDisponivelGetResponseDTO toGetDTO(){
        return new HorarioDisponivelGetResponseDTO(
            getId_horario(),
            getProfissional().toGetDTO(),
            getData(),
            getHora_inicio(),
            getHora_fim(),
            getStatus().toString()
        );
    }

}

