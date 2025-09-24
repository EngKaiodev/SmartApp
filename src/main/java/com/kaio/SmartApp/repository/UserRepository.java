package com.kaio.SmartApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kaio.SmartApp.entity.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);
    List<UserModel> findAllByType(Integer type);

    @Query(value = """
    SELECT 
        u.id,
        u.complete_name,
        u.phone,
        AVG(r.review) as rate,
        COUNT(*) as reviewsCount
    FROM users u
        join reviews r on r.pro_id = u.id
    where   u.type = 1
    GROUP BY u.id, u.complete_name, u.phone
    """, nativeQuery = true)
    List<Object[]> findPros();
}
