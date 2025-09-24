package com.kaio.SmartApp.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaio.SmartApp.entity.Review;
import com.kaio.SmartApp.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping()
    public ResponseEntity<Review> save(@RequestBody Review request){
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.save(request));
    }

    @GetMapping()
    public ResponseEntity<List<Review>> getAll(){
        return ResponseEntity.ok().body(reviewService.getAll());
    }
}
