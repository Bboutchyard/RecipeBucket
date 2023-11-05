package com.example.recipebucket;

import androidx.annotation.NonNull;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

    public class recipeAdapter extends RecyclerView.Adapter<recipeAdapter.MyViewHolder> {

        Context context;
        ArrayList<Recipe> recipeArrayList;

        public recipeAdapter(Context context, ArrayList<Recipe> recipeArrayList) {
            this.context = context;
            this.recipeArrayList = recipeArrayList;
        }

        @NonNull
        @Override
        public recipeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(context).inflate(R.layout.recipelist,parent,false);

            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Recipe recipe = recipeArrayList.get(position);
            holder.name.setText(recipe.name);

        }

        @Override
        public int getItemCount() {
            return recipeArrayList.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView name;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.tvRecipeName);
            }
        }
    }
