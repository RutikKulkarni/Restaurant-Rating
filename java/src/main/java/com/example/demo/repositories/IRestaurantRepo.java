package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Restaurant;

public interface IRestaurantRepo {
    Restaurant save(Restaurant restaurant);
    void updateRating(Long id, Integer rating);
    Restaurant describeResto(Long id);
    List<String> getRestosList();
}
