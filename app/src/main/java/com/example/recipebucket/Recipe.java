package com.example.recipebucket;

import android.util.Log;

public class Recipe {
    private String directions;

    public Recipe() {
        // Default constructor is required for Firestore
    }

    public Recipe(String directions) {
        this.directions = directions;
    }

    public String getDirections() {
        return directions;
    }

    public void setDescription(String description) {
        this.directions = description;
    }
}