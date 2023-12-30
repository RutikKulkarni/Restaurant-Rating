package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepo;

public class UserService {
    // The data access object for User entities
    private final IUserRepo iUserRepo;
    
    // Constructs a new UserService with the given IUserRepo implementation
    public UserService(IUserRepo iUserRepo){
        this.iUserRepo = iUserRepo;
    }

    // Creates a new user
    public User createUser(User user){
        return iUserRepo.save(user);
    }
}
