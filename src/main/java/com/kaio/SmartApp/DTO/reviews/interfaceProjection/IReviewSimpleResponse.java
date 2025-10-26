package com.kaio.SmartApp.DTO.reviews.interfaceProjection;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface IReviewSimpleResponse {
    String getCompleteName();

    String getComment();

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime getDate();

    Double getReview();
}
