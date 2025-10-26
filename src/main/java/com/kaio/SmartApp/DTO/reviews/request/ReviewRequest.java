package com.kaio.SmartApp.DTO.reviews.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ReviewRequest {
    private int pro_id;
    private int cli_id;
    private int schedule_id;
    private int review;
    private String comment;
    private LocalDateTime date;
}
