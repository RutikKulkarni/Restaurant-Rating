package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.repositories.RestaurantRepo;
import com.example.demo.services.RestaurantService;
import com.example.demo.services.ReviewService;

public class CreateReviewCommand implements ICommand{
    private final ReviewService reviewService;
    private final RestaurantService restaurantService;

    // Constructs a new CreateReviewCommand object with the given review and restaurant services
    public CreateReviewCommand(ReviewService reviewService,RestaurantService restaurantService){
        this.reviewService = reviewService;
        this.restaurantService = restaurantService;
    }

    // Executes the command with the given tokens
    @Override
    public void invoke(List<String> tokens) {
        // Extract the rating, user ID, and restaurant ID from the tokens
        String rating = tokens.get(1);
        String userid = tokens.get(2);
        String restaurantid = tokens.get(3);
        // Extract the dishes from the tokens
        List<String> dishes = new ArrayList<>();
        for (int i = 4; i < tokens.size(); i++) {
            dishes.add(tokens.get(i));
        }
        // Create a new review object with the extracted data
        Review r = new Review(Integer.valueOf(rating), Long.valueOf(userid),Long.valueOf(restaurantid), dishes);
        // Add the new review to the review service
        Review createReview = reviewService.addReview(r);
        // Update the rating of the restaurant in the restaurant service
        restaurantService.updateRating(Long.valueOf(restaurantid), Integer.valueOf(rating));
        System.out.println(createReview.toString());
    }
}
