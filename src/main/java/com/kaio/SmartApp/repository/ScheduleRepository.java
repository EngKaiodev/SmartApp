package com.kaio.SmartApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByUserId(int userId);
    List<Schedule> findAllByProId(int proId);
}
