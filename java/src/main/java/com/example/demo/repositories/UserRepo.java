package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.entities.User;

public class UserRepo implements IUserRepo{
    private final Map<Long,User> userDB; 
    private Long autoIncrement = 1L;

    public UserRepo(){
        this.userDB = new HashMap<>();
    }

    public User save(User u){
        u.assignId(autoIncrement);
        userDB.putIfAbsent(autoIncrement++,u);
        return u;
    }
}
