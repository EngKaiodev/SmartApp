package com.kaio.SmartApp.DTO.reviews;

import java.sql.Timestamp;

import com.kaio.SmartApp.DTO.reviews.response.ReviewSimpleResponse;

public class ReviewMapper {
    public static ReviewSimpleResponse toSimpleResponse(Object[] obj){
        ReviewSimpleResponse simpleResponse = new ReviewSimpleResponse();
        simpleResponse.setComplete_name((String) obj[0]);
        simpleResponse.setComment((String) obj[1]);
        simpleResponse.setDate((Timestamp) obj[2]);
        simpleResponse.setReview((int) obj[3]);
        return simpleResponse;
    }

}
