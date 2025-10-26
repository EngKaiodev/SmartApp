package com.kaio.SmartApp.DTO.reviews;

import java.time.LocalDateTime;

import com.kaio.SmartApp.DTO.reviews.request.ReviewRequest;
import com.kaio.SmartApp.DTO.reviews.response.ReviewSimpleResponse;
import com.kaio.SmartApp.entity.Review;

public class ReviewMapper {
    public static ReviewSimpleResponse toSimpleResponse(Object[] obj){
        ReviewSimpleResponse simpleResponse = new ReviewSimpleResponse();
        simpleResponse.setComplete_name((String) obj[0]);
        simpleResponse.setComment((String) obj[1]);
        simpleResponse.setDate((LocalDateTime) obj[2]);
        simpleResponse.setReview((int) obj[3]);
        return simpleResponse;
    }

    public static Review toEntity(ReviewRequest request){
        Review response = new Review();

        response.setCli_id(request.getCli_id());
        response.setComment(request.getComment());
        response.setDate(request.getDate());
        response.setPro_id(request.getPro_id());
        response.setReview(request.getReview());
        response.setSchedule_id(request.getSchedule_id());

        return response;
    }

}
