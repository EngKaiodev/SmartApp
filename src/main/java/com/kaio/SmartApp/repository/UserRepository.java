package com.kaio.SmartApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaio.SmartApp.entity.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);
    List<UserModel> findAllByType(Integer type);

    @Query(value = """
    SELECT 
        u.id,
        u.complete_name,
        u.phone,
        COALESCE(AVG(r.review), 5) AS rate,
        COALESCE(COUNT(r.id), 0) AS reviewsCount
    FROM users u
    LEFT JOIN reviews r ON r.pro_id = u.id
    WHERE u.type = 1
    GROUP BY u.id, u.complete_name, u.phone;
    """, nativeQuery = true)
    List<Object[]> findPros();

    @Query(value = """
    SELECT 
        u.id,
        u.complete_name,
        u.phone,
        COALESCE(AVG(r.review), 5) AS rate,
        COALESCE(COUNT(r.id), 0) AS reviewsCount
    FROM users u
    LEFT JOIN reviews r ON r.pro_id = u.id
    WHERE u.id = :id and u.type = 1
    GROUP BY u.id, u.complete_name, u.phone LIMIT 1;
    """, nativeQuery = true)
    List<Object[]> findOneById(@Param("id") int id);
}
