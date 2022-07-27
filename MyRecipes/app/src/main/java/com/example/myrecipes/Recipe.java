package com.example.myRecipes;

import java.util.List;

public class Recipe {
    String Recipe;
    Integer dishSize;
    List<String> ingredientsList;
    List<String> stepsList;

    public Recipe(List<com.example.myRecipes.Recipe> dataList) {
        Recipe = dataList.get(0).getRecipe();
        this.dishSize = dataList.get(0).getDishSize();
        this.ingredientsList = dataList.get(0).getIngredientsList();
        this.stepsList = dataList.get(0).getStepsList();
    }

    public Recipe(String recipe, Integer dishSize, List<String> ingredientsList, List<String> stepsList) {
        Recipe = recipe;
        this.dishSize = dishSize;
        this.ingredientsList = ingredientsList;
        this.stepsList = stepsList;
    }

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

    public List<String> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public List<String> getStepsList() {
        return stepsList;
    }

    public void setStepsList(List<String> stepsList) {
        this.stepsList = stepsList;
    }
}