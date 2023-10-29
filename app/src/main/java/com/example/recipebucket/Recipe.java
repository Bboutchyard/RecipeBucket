package com.example.recipebucket;

public class Recipe {
    private String description;

    public Recipe() {
        // Default constructor is required for Firestore
    }

    public Recipe(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}