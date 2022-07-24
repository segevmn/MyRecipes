package com.example.myRecipes;

public class Recipe {
    String Recipe;
    Integer dishSize;

    public String getRecipe() {
        return Recipe;
    }

    public void setRecipe(String recipe) {
        Recipe = recipe;
    }

    public Integer getDishSize() {
        return dishSize;
    }

    public void setDishSize(Integer dishSize) {
        this.dishSize = dishSize;
    }
}