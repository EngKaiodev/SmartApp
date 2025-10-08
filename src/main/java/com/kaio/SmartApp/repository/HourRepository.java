package com.kaio.SmartApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.Hours;

public interface HourRepository extends JpaRepository<Hours, Integer> {
    List<Hours> findAllByUserId(int userId);
}
