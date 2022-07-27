package com.example.myRecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    Context context;
    ArrayList<Recipe> myRecipes;

    public MenuAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewRecipe = inflater.inflate(R.layout.recipe_item, parent, false);
        return new ViewHolder(viewRecipe);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = myRecipes.get(position);
        holder.recipeName.setText(recipe.getRecipe());
        holder.dishSize.setText(recipe.getDishSize());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView recipeName;
        public TextView dishSize;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            recipeName = itemView.findViewById(R.id.RecipeName);
            dishSize = itemView.findViewById(R.id.DishSize);
        }
    }
}