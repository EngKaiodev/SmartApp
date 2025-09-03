package com.kaio.SmartApp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Servicos")
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Servicos implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false, unique=false, length=50) 
    private String name;
    @Column(nullable=false, unique=false, length=50) 
    private String description;
    @Column(nullable=false, unique=false, length=50) 
    private float price;
    @Column(nullable=false, unique=false, length=50) 
    private int duration;

    @ManyToMany(mappedBy = "servicos")
    @JsonBackReference
    private List<Profissional> profissionais = new ArrayList<>();

    public Servicos(String name, String description, float price, int duration, List<Profissional> profissionais) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.profissionais = profissionais;
    }
}
