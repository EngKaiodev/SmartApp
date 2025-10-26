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

@Table(name = "schedule")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int proId;
    private int serviceId;
    private int hourId;
    private int status; // 0 - aguardando confirmação 1 - confirmado 2 - cancelado 3 - Realizado 4 - Avaliado
}
