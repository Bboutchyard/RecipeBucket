package com.example.recipebucket;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class recipeAdapter {
    //Integrate database calls to ID's associated with recipes.java and addEditDeleteRecipe.java

        private FirebaseFirestore db;

        public recipeAdapter() {
            db = FirebaseFirestore.getInstance();
        }

    public void addRecipeToFirestore(String recipeName, int servings, List<Map<String, Object>> ingredients, List<String> instructions) {
        Map<String, Object> recipeData = new HashMap<>();
        recipeData.put("recipeName", recipeName);
        recipeData.put("servings", servings);
        recipeData.put("ingredients", ingredients);
        recipeData.put("instructions", instructions);

        db.collection("recipes")
                .add(recipeData)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Recipe added successfully
                        // Handle success as needed
                    } else {
                        // Handle the error
                    }
                });
    }
    }





}
