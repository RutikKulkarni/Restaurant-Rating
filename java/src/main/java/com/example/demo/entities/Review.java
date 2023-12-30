package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

public class Review {
    // unique identifier for the review
    private Long reviewId;
    // the rating for the review, on a scale of 1 to 5
    private final Integer rating;
    // the unique identifier of the user who left the review
    private final Long userId;
    // the unique identifier of the restaurant the review is for
    private final Long restaurantId;
    // // the dishes that the user ordered and reviewed, as a list
    private List<String> dishes;

    // Constructor for a new review object
    public Review(Integer rating,Long userId,Long restaurantId,List<String> dishes){
        this.rating = rating;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.dishes = new ArrayList<>();
        this.reviewId = null;
    }

    // Assigns a unique identifier to the review
    public void assignId(Long id) {
        this.reviewId  = id;
    }

    // Generates a string representation of the review object
    @Override
    public String toString(){
        return "Review [id="+reviewId+"] added successfully for Restaurant [id="+restaurantId+"] by User [id="+userId+"]!";
    }
    // enerates a string representation of the review object, including only the review's unique identifier
    public String toStringReview(){
        return "Review [id="+reviewId+"]";
    }
    // Returns the rating of the review
    public Integer getRating(){
        return rating;
    }

    // Returns the unique identifier of the restaurant the review is for
    public Long getRestaurantID() {
        return restaurantId;
    }

}
