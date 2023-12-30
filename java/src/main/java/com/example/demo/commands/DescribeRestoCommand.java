package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;

public class DescribeRestoCommand implements ICommand {
    private final RestaurantService restaurantService;

    // Constructs a new DescribeRestoCommand object with the given 
    public DescribeRestoCommand(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    // Executes the command with the given tokens
    @Override
    public void invoke(List<String> tokens) {
        // Extract the restaurant ID from the tokens
        String id = tokens.get(1);
        // Retrieve the restaurant object with the given ID from the restaurant service
        Restaurant descRestaurant = restaurantService.describeResto(Long.valueOf(id));
        System.out.println(descRestaurant.describe());
    }
}
