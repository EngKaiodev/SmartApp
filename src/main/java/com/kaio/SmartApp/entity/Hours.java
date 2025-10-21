package com.kaio.SmartApp.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "hours", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "userId", "initHour" })
})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;

    private LocalDateTime initHour;
    private LocalDateTime endHour;

    private String status; // booked || opened
}
