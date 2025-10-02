package com.kaio.SmartApp.DTO.reviews.response;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReviewSimpleResponse {
    private String complete_name;
    private String comment;
    private Timestamp date;
    private int review;
}
