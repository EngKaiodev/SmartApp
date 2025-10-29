package com.kaio.SmartApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kaio.SmartApp.DTO.reviews.interfaceProjection.IReviewSimpleResponse;
import com.kaio.SmartApp.DTO.reviews.response.ReviewDataResponse;
import com.kaio.SmartApp.DTO.reviews.response.ReviewToList;
import com.kaio.SmartApp.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("SELECT r.review FROM Review r WHERE r.schedule_id = :id")
    Optional<Integer> getRateById(@Param("id") int id);

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

    @Query(value = """
                SELECT
                    COUNT(*) AS total_avaliacoes,
                    ROUND(AVG(review), 2) AS media_avaliacoes,
                    SUM(CASE WHEN review = 5 THEN 1 ELSE 0 END) AS nota_5,
                    SUM(CASE WHEN review = 4 THEN 1 ELSE 0 END) AS nota_4,
                    SUM(CASE WHEN review = 3 THEN 1 ELSE 0 END) AS nota_3,
                    SUM(CASE WHEN review = 2 THEN 1 ELSE 0 END) AS nota_2,
                    SUM(CASE WHEN review = 1 THEN 1 ELSE 0 END) AS nota_1
            FROM reviews
            WHERE pro_id = :id
            GROUP BY pro_id;
                """, nativeQuery = true)
    Optional<ReviewDataResponse> getAllReviewsData(@Param("id") int id);

    @Query(value = """
            select
                u.complete_name as name,
                r.comment, r.date,
                r.review
                from reviews r
                join users u on u.id = r.cli_id
                where r.pro_id = :id;
                            """, nativeQuery = true)
    List<ReviewToList> getReviewsForList(@Param("id") int id);
}
