package com.kaio.SmartApp.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.Hours;

public interface HourRepository extends JpaRepository<Hours, Integer> {
    // Busca por usuário e status em um determinado dia (intervalo do dia)
    default List<Hours> findAllByUserIdAndDateAndStatus(int userId, LocalDate date, String status) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);
        return findAllByUserIdAndInitHourBetweenAndStatus(userId, start, end, status);
    }

    default List<Hours> findAllByUserIdAndDate(int userId, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);
        return findAllByUserIdAndInitHourBetween(userId, start, end);
    }

    // Busca por usuário e initHour exato (mantida a semântica original)
    Optional<Hours> findByUserIdAndInitHour(int userId, LocalDateTime initHour);

    // Deleta todos que não têm o status informado dentro da data
    default void deleteByUserIdAndDateAndStatusNot(int userId, LocalDate date, String status) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);
        deleteByUserIdAndInitHourBetweenAndStatusNot(userId, start, end, status);
    }

    // Métodos auxiliares que o Spring Data JPA consegue gerar automaticamente
    List<Hours> findAllByUserIdAndInitHourBetweenAndStatus(int userId, LocalDateTime start, LocalDateTime end, String status);
    List<Hours> findAllByUserIdAndInitHourBetween(int userId, LocalDateTime start, LocalDateTime end);

    void deleteByUserIdAndInitHourBetweenAndStatusNot(int userId, LocalDateTime start, LocalDateTime end, String status);
}
