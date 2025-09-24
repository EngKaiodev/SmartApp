package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.entity.Review;
import com.kaio.SmartApp.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository repository;

    @Transactional(readOnly = false)
    public Review save(Review request){
        return repository.save(request);
    }

    @Transactional(readOnly = true)
    public List<Review> getAll(){
        return repository.findAll();
    }

}
