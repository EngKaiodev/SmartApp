package com.kaio.SmartApp.DTO.reviews.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface ReviewToList {

    String getName();
    String getComment();    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime getDate();
    Integer getReview();

}
