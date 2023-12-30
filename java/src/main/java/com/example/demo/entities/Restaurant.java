package com.example.demo.entities;

public class Restaurant {
    private  Long id;
    private  String name;
    private  Double rating;


    private  Double one;
    private  Double two;
    private  Double three;
    private  Double four;
    private  Double five;

    // Constructs a new restaurant with a given name and default statistics
    public Restaurant(String name){
        this.name = name;
        this.id  = null;
        this.rating = null;
        
        this.one = (double) 0;
        this.two = (double) 0;
        this.three = (double)0;
        this.four = (double)0;
        this.five = (double)0;
    }

    // Assigns an ID to this restaurant
    public void assignId(Long id){
        this.id = id;
    }

    // Returns a string representation of this restaurant, including its Id
    @Override
    public String toString(){
        return "Restaurant [id="+id+"]";
    }

    // Returns a string representation of this restaurant, including its name, ID, and rating
    public String describe(){
        return "Restaurant [id="+id+", name="+name+", rating="+rating+"]";
    }

    // Updates the number of reviews that gave this restaurant a rating of 1, 2, 3, 4, 5
    public void set1() {
        one++;
    }
    public void set2() {
        two++;
    }
    public void set3() {
        three++;
    }
    public void set4() {
        four++;
    }
    public void set5() {
        five++;
    }

    public void setRating() {
        rating =  ((one + (two)*2 + (three)*3 + (four)*4 + (five)*5) / (one+two+three+four+five));
    }

    public Double getRating(){
        return rating;
    }
}
