package com.example.demo.commands;

public enum CommandKeyword {

    // Register Command Keywords
    CREATE_GREETING_COMMAND("CREATE_GREETING"),
    LIST_GREETING_COMMAND ("LIST_GREETING"),
    GET_GREETING_COMMAND ("GET_GREETING"),
    // To register user
    REGISTER_USER_COMMAND("REGISTER_USER"),
    // To register resto
    REGISTER_RESTAURANT_COMMAND("REGISTER_RESTAURANT"),
    // To add review
    ADD_REVIEW("ADD_REVIEW"),
    // To add rating
    ADD_RATING("ADD_RATING"),
    // To get reviews
    GET_REVIEWS("GET_REVIEWS"),
    GET_REVIEWS_FILTER_ORDER("GET_REVIEWS_FILTER_ORDER"),
    // To get descripton of resto
    DESCRIBE_RESTAURANT("DESCRIBE_RESTAURANT"),
    // Total list of resto
    LIST_RESTAURANTS("LIST_RESTAURANT");

    private final String name;
    private CommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
     } 
}
