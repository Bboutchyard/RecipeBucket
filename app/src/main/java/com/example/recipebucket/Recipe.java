package com.example.recipebucket;

import com.google.firebase.firestore.CollectionReference;

public class Recipe {
    String name, instructions;

    public Recipe() {
        
    }

    public String getName() {
        return name;
    }

    public Recipe(String name, String instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}