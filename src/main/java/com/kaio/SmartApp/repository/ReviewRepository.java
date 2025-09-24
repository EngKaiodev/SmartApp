package com.kaio.SmartApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaio.SmartApp.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
