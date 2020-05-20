package com.example.harkkaty;

public class FoodItem {

    private String name;
    private String id;

    FoodItem(String name1, String id1) {
        name = name1;
        id = id1;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
