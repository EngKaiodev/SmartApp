package com.kaio.SmartApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByUserId(int userId);
    List<Schedule> findAllByProId(int proId);
    List<Schedule> findAllByUserIdAndStatusIn(int userId, List<Integer> status);
    List<Schedule> findAllByProIdAndStatusIn(int proId, List<Integer> status);
    Optional<Schedule> findByUserIdAndServiceIdAndProId (int userId, int serviceId, int proId);

}
