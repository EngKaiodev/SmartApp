package com.kaio.SmartApp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaio.SmartApp.DTO.reviews.interfaceProjection.IReviewSimpleResponse;
import com.kaio.SmartApp.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = """
            SELECT 
            u.complete_name,
            r.comment,
            r.date,
            r.review
        FROM REVIEWS r
        LEFT JOIN USERS u ON u.id = r.cli_id
        WHERE r.pro_id = :id
        ORDER BY r.date DESC
        LIMIT 3;
    """, nativeQuery = true)
    List<IReviewSimpleResponse> findLast3ById(@Param("id") int id);
}
