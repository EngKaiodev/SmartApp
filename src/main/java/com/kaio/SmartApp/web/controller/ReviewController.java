package com.kaio.SmartApp.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.DTO.reviews.request.ReviewRequest;
import com.kaio.SmartApp.DTO.reviews.response.AllReviewResponse;
import com.kaio.SmartApp.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping()
    public ResponseEntity<Boolean> save(@RequestBody ReviewRequest request){
        Boolean response = reviewService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{proId}")
    public ResponseEntity<AllReviewResponse> getAll(@PathVariable("proId") int proId){
        return ResponseEntity.ok().body(reviewService.getReviewToList(proId));
    }
}
