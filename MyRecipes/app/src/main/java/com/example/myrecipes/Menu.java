package com.example.myrecipes;

public class Menu {
    String DishName;

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public Menu (String DishName){
        this.DishName = DishName;
    }
}
