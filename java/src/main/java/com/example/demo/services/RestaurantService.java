package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IRestaurantRepo;

public class RestaurantService {
    private final IRestaurantRepo iRestaurantRepo;
    
    // Constructor that takes an instance of IRestaurantRepo
    public RestaurantService(IRestaurantRepo iRestaurantRepo){
        this.iRestaurantRepo = iRestaurantRepo;
    }

    // Method to create a new restaurant: Takes a Restaurant object as an argument and returns the created restaurant
    public Restaurant createRestaurant(Restaurant restaurant){
        return iRestaurantRepo.save(restaurant);
    }

    // Method to update the rating of a restaurant: Takes a Long id and an Integer rating as arguments
    public void updateRating(Long id,Integer rating){
        iRestaurantRepo.updateRating( id, rating);
    }

    // Method to describe a restaurant: Takes a Long id as an argument and returns the restaurant
    public Restaurant describeResto(Long id) {
        return iRestaurantRepo.describeResto(id);
    }

    // Returns a list of String objects
    public List<String> getRestosList() {
        return iRestaurantRepo.getRestosList();
    }
}
