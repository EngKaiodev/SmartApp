package com.kaio.SmartApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaio.SmartApp.DTO.reviews.ReviewMapper;
import com.kaio.SmartApp.DTO.reviews.interfaceProjection.IReviewSimpleResponse;
import com.kaio.SmartApp.DTO.reviews.request.ReviewRequest;
import com.kaio.SmartApp.DTO.reviews.response.AllReviewResponse;
import com.kaio.SmartApp.DTO.reviews.response.ReviewDataResponse;
import com.kaio.SmartApp.DTO.reviews.response.ReviewToList;
import com.kaio.SmartApp.entity.Review;
import com.kaio.SmartApp.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository repository;

    @Transactional(readOnly = false)
    public Boolean save(ReviewRequest request){
       repository.save(ReviewMapper.toEntity(request));
       return true;
    }

    @Transactional(readOnly = true)
    public List<Review> getAll(){
        return repository.findAll();
    }

    @Transactional (readOnly = true)
    public List<IReviewSimpleResponse> getLast3byId(int id){
        List<IReviewSimpleResponse> responses = repository.findLast3ById(id);
        return responses;
    }

    @Transactional (readOnly = true)
    public AllReviewResponse getReviewToList(int proId){
         ReviewDataResponse data = repository.getAllReviewsData(proId).orElse(null);

         List<ReviewToList> listReview = repository.getReviewsForList(proId);

         return new AllReviewResponse(data, listReview);
    }

    @Transactional(readOnly = true)
    public int getRateById(int id){
        return repository.getRateById(id).orElse(0);
    }
}
