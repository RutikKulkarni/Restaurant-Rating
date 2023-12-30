package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;

public class CreateRestaurantCommand implements ICommand{
    
    private final RestaurantService restaurantService;

    // Constructs a new CreateRestaurantCommand object with the given restaurant service
    public CreateRestaurantCommand(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    // Executes the command with the given tokens
    @Override
    public void invoke(List<String> tokens) {
        // Extract the name of the restaurant from the tokens
        String name = tokens.get(1);
        // Create a new restaurant object with the extracted name
        Restaurant createreRestaurant = restaurantService.createRestaurant(new Restaurant(name));
        System.out.println(createreRestaurant.toString());
    }
}
