package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.repositories.IReviewRepo;

public class ReviewService {
    private final IReviewRepo iReviewRepo;

    // Constructor to initialize IReviewRepo instance
    public ReviewService(IReviewRepo iReviewRepo){
        this.iReviewRepo = iReviewRepo;
    }

    // to add a review
    public Review addReview(Review review){
        return iReviewRepo.save(review);
    }

    // to get all reviews in desc and Asc order of rating for a restaurant
    public List<String> reviewDesc(Long id) {
        return iReviewRepo.getAllReviewDesc(id);
    }

    public List<String> reviewAsc(Long id) {
        return iReviewRepo.getAllReviewAsc(id);
    }

    // to get filtered reviews in desc and Asc order of rating for a restaurant
    public List<String> filteredReviewsDsc(Long id, Integer low, Integer high) {
        return iReviewRepo.filteredReviewsDsc( id,  low,  high);
    }

    public List<String> filteredReviewsAsc(Long id, Integer low, Integer high) {
        return iReviewRepo.filteredReviewsAsc( id,  low,  high);
    }

}
