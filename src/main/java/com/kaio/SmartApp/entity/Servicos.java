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
    @Column(name = "pro_id", nullable = false)
    private int proId;
}
