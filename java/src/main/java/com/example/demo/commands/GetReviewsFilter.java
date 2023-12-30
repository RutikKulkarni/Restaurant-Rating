package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class GetReviewsFilter implements ICommand{
    private final ReviewService reviewService;

    public GetReviewsFilter(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String id = tokens.get(1);
        String low = tokens.get(2);
        String high = tokens.get(3);
        String order = tokens.get(4);
        List<String> result;
        if(order.charAt(7) == 'A')  result = reviewService.filteredReviewsAsc(Long.valueOf(id),Integer.valueOf(low),Integer.valueOf(high));
        else result = reviewService.filteredReviewsDsc(Long.valueOf(id),Integer.valueOf(low),Integer.valueOf(high));
        
        System.out.println(result);
    }
}