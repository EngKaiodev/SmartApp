package com.kaio.SmartApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "address")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String zipCode;
    private String address;
    private String number;
}
