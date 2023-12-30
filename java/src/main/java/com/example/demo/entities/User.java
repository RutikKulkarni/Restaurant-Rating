package com.example.demo.entities;

public class User {
    private String name;
    private Long id;

    // Constructs a new User object with the given name
    public User(String name){
        this.name = name;
        this.id = null;
    }

    // Assigns an ID to the user
    public void assignId(Long id){
        this.id = id;
    }

    // Returns a string representation of the User object
    @Override
    public String toString(){
        return "User [id="+id+"]";
    }
}
