package com.kaio.SmartApp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kaio.SmartApp.DTO.servico.response.ServicoGetRespondeDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Table(name="Servicos")
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Servico implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_servico;
    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private Profissional profissional;
    @Column(nullable=false, unique=false, length=50) 
    private String nome;
    @Column(nullable=false, unique=false, length=50) 
    private String descricao;
    @Column(nullable=false, unique=false, length=50) 
    private float preco;
    @Column(nullable=false, unique=false, length=50) 
    private int duracao;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.REMOVE, orphanRemoval = false)
    @JsonBackReference
    private List<Agendamento> agendamentos = new ArrayList<>();
    
    public Servico(Profissional profissional, String nome_servico, String descricao, float preco, int duracao) {
        this.profissional = profissional;
        this.nome = nome_servico;
        this.descricao = descricao;
        this.preco = preco;
        this.duracao = duracao;
    }


    public ServicoGetRespondeDTO toGetDTO(){
        return new ServicoGetRespondeDTO(
            getId_servico(),
            getProfissional().toGetDTO(),
            getNome(),
            getDescricao(),
            getPreco(),
            getDuracao()
        );
    }
}
