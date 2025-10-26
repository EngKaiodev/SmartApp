package com.kaio.SmartApp.entity;

import java.time.LocalDateTime;

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

@Table(name = "reviews")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int pro_id;
    private int cli_id;
    private int schedule_id;
    private int review;
    @Column(columnDefinition = "TEXT")
    private String comment;
    private LocalDateTime date;
}
