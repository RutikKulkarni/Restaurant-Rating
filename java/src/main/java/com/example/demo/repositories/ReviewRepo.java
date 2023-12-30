package com.example.demo.repositories;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;
import com.example.demo.entities.Review;

public class ReviewRepo implements IReviewRepo{
    private final HashMap<Long,Review> reviewDB;
    private Long autoIncrement = 1L;

    // Constructs a new ReviewRepo object and initializes the reviewDB HashMap
    public ReviewRepo(){
        this.reviewDB = new HashMap<>();
    }

    // Saves the given Review object to the reviewDB HashMap with an auto-incremented review Id
    public Review save(Review review){
        review.assignId(autoIncrement);
        reviewDB.putIfAbsent(autoIncrement++, review);
        return review;
    }

    // Retrieves all reviews for a given restaurant ID in desc & Asc order of rating
    public List<String> getAllReviewDesc(Long id){
        List<String> reviewStrings = reviewDB.values().stream().sorted(Comparator.comparing(Review::getRating).reversed())
        .filter(r -> r.getRestaurantID() == id).map(Review::toStringReview).collect(Collectors.toList());
        return reviewStrings;   
    }

    public List<String> getAllReviewAsc(Long id){
        List<String> reviewStrings = reviewDB.values().stream().sorted(Comparator.comparing(Review::getRating).reversed())
        .filter(r -> r.getRestaurantID() == id).map(Review::toStringReview).collect(Collectors.toList());
        Collections.reverse(reviewStrings);
        return reviewStrings;        
    }

    // Retrieves filtered reviews for a given restaurant ID in ascending & Desc order of rating within a rating range
    public List<String> filteredReviewsAsc(Long id, Integer low, Integer high){
        List<String> reviewStrings = reviewDB.values().stream().
        sorted(Comparator.comparing(Review::getRating))
        .filter(r -> r.getRestaurantID() == id && r.getRating() <= high && r.getRating() >= low)
        .map(Review::toStringReview).
        collect(Collectors.toList());
        return reviewStrings;        
    }

    public List<String> filteredReviewsDsc(Long id, Integer low, Integer high){
        List<String> reviewStrings = reviewDB.values().stream().
        sorted(Comparator.comparing(Review::getRating).reversed())
        .filter(r -> r.getRestaurantID() == id && r.getRating() <= high && r.getRating() >= low)
        .map(Review::toStringReview).
        collect(Collectors.toList());
        return reviewStrings;        
    }


}