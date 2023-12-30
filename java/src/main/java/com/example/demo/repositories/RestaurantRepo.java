package com.example.demo.repositories;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;

public class RestaurantRepo implements IRestaurantRepo{
    private final Map<Long,Restaurant> restaurantDB; 
    private Long autoIncrement = 1L;

    public RestaurantRepo(){
        this.restaurantDB = new HashMap<>();
    }

    public Restaurant save(Restaurant r){
        r.assignId(autoIncrement);
        restaurantDB.putIfAbsent(autoIncrement++,r);
        return r;
    }

    public void updateRating(Long id,Integer rating){
        switch (rating) {
            case 1:
                restaurantDB.get(id).set1();
                break;
            case 2:
                restaurantDB.get(id).set2();
                break;                
            case 3:
                restaurantDB.get(id).set3();
                break;
            case 4:
                restaurantDB.get(id).set4();
                break;
            case 5:
                restaurantDB.get(id).set5();
                break;
            default:
                break;
        }
        Restaurant r = restaurantDB.get(id);
        r.setRating();
    }

    public Restaurant describeResto(Long id){
        return restaurantDB.get(id);
    }

    public List<String> getRestosList(){
        List<String> result = restaurantDB.values().stream().
        sorted(Comparator.comparing(Restaurant::getRating)).map(Restaurant::toString).
        collect(Collectors.toList());
        Collections.reverse(result);
        return result;
    }
}
