package com.kaio.SmartApp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kaio.SmartApp.DTO.profissional.response.ProfissionalGetResponseDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    @Column(nullable=false, unique=false) 
    private String senha;
    @Column(nullable=false, unique=true, length=100) 
    private String cnpj;

    @ManyToMany
    @JoinTable(name = "profissional_especialidade",
    joinColumns = {@JoinColumn(name = "profissional_id")},
    inverseJoinColumns = {@JoinColumn(name = "servicos_id")})
    private List<Servicos> servicos = new ArrayList<>();

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.REMOVE, orphanRemoval = false)
    @JsonBackReference("profissional-horarios")
    private List<HorarioDisponivel> horarioDisponiveis = new ArrayList<>();

    public ProfissionalGetResponseDTO toGetDTO(){
        return new ProfissionalGetResponseDTO(
            getId_profissional(),
            getRazao_social(),
            getContato(),
            getEmail(),
            getServicos()
        );
    }
}
