package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

public class CreateUserCommand implements ICommand{
    
    private final UserService userService;
    
    public CreateUserCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        User createUser = userService.createUser(new User(name));
        System.out.println(createUser.toString());
    }
    
}
