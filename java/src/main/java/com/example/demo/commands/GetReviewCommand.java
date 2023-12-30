package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class GetReviewCommand implements ICommand{
    private final ReviewService reviewService;

    // Constructs a new GetReviewCommand object with the given review service
    public GetReviewCommand(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    // Executes the command with the given tokens
    @Override
    public void invoke(List<String> tokens) {
        // Extract the restaurant ID and the desired order of the reviews from the tokens
        String id = tokens.get(1);
        String order = tokens.get(2);
        // Retrieve the reviews for the restaurant with the given ID based on the desired order
        List<String> result;
        if(order.charAt(0) == 'D')  result = reviewService.reviewDesc(Long.valueOf(id));
        else result = reviewService.reviewAsc(Long.valueOf(id));
        System.out.println(result);
    }
    
}
