package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.repositories.IRestaurantRepo;
import com.example.demo.repositories.RestaurantRepo;
import com.example.demo.services.RestaurantService;
import com.example.demo.services.ReviewService;

public class CreateRatingCommand implements ICommand{
    private final ReviewService reviewService;
    private final RestaurantService restaurantService;

    // Constructs a new CreateRatingCommand object with the given services
    public CreateRatingCommand(ReviewService reviewService,RestaurantService restaurantService){
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
        // Create a new review object with the extracted data and an empty list of dishes
        List<String> dishes = null;

        Review r = new Review(Integer.valueOf(rating), Long.valueOf(userid),Long.valueOf(restaurantid), dishes);
        // Add the review to the review service
        Review createReview = reviewService.addReview(r);
        // Update the rating of the restaurant in the restaurant service
        restaurantService.updateRating(Long.valueOf(restaurantid), Integer.valueOf(rating));
        System.out.println(createReview.toString());
    }
}