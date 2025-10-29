package com.kaio.SmartApp.DTO.reviews.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AllReviewResponse {

    private ReviewDataResponse data;
    private List<ReviewToList> reviewsList;

}
