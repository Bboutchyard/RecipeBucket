package com.example.recipebucket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import androidx.gridlayout.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class recipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        // Your code to fetch data from Firestore goes here
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference recipesRef = db.collection("recipe");

        recipesRef.get()

                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {

                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<Recipe> recipeList = new ArrayList<>();
                        Log.d("FirestoreQuery", "Fetching data from Firestore");

                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            Recipe recipe = document.toObject(Recipe.class);
                            recipeList.add(recipe);
                        }

                        for (Recipe recipe : recipeList) {
                            // Create a new CardView for each recipe
                            CardView cardView = new CardView(recipes.this);
                            CardView.LayoutParams cardParams = new CardView.LayoutParams(
                                    CardView.LayoutParams.MATCH_PARENT,
                                    CardView.LayoutParams.WRAP_CONTENT
                            );
                            cardView.setLayoutParams(cardParams);

                            // Create a TextView for the recipe description
                            TextView descriptionTextView = new TextView(recipes.this);
                            descriptionTextView.setLayoutParams(new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT
                            ));
                            descriptionTextView.setText(recipe.getDirections());
                            Log.d("directions", descriptionTextView.getText().toString());

                            // Add the TextView to the CardView
                            cardView.addView(descriptionTextView);

                            // Add the CardView to the existing GridLayout in your layout
                            GridLayout gridLayout = findViewById(R.id.gridLayout); // Replace with the actual ID of your GridLayout
                            gridLayout.addView(cardView);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Handle any errors that occur during the fetch.

                        // For example, you can log the error message for debugging purposes:
                        Log.e("FirestoreFetch", "Error fetching recipes: " + e.getMessage());

                        // You can also display a message to the user indicating the error.
                        // For simplicity, we're using a Toast in this example:
                        Toast.makeText(recipes.this, "Error fetching recipes. Please try again later.", Toast.LENGTH_SHORT).show();

                        // Additionally, you might want to hide or update UI elements to indicate the error.
                        // For instance, you can hide a progress bar or display a retry button.
                    }
                });


    }
}