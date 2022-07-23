package com.example.myrecipes;

public class Recipe {
    String Recipe;
    Integer dishSize;
    String recipeProgress;

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

    public String getRecipeProgress() {
        return recipeProgress;
    }

    public void setRecipeProgress(String recipeProgress) {
        this.recipeProgress = recipeProgress;
    }
}
