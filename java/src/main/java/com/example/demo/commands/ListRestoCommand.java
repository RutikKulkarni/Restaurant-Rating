package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.RestaurantService;

public class ListRestoCommand implements ICommand{
    
    private final RestaurantService restaurantService;

    public ListRestoCommand(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }
    
    @Override
    public void invoke(List<String> tokens) {
        List<String> res = restaurantService.getRestosList();
        System.out.println(res);
    }
}
