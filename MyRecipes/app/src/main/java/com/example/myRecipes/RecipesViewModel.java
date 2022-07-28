package com.example.myRecipes;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipesViewModel extends AndroidViewModel {
    MutableLiveData<ArrayList<Recipe>> recipes;
    MutableLiveData<Integer> index;
    MutableLiveData<Integer> itemSelected;
    public static  RecipesViewModel instance;
    public RecipesViewModel(@NonNull Application application, Context context, Activity activity){
        super(application);
        MutableLiveData<ArrayList<Recipe>> RecipeLiveData;
        int currentrecipe;
        recipes = new MutableLiveData<>();
        index = new MutableLiveData<>();
        itemSelected = new MutableLiveData<>();
        index.setValue(RecyclerView.NO_POSITION);
        ArrayList<Recipe> myRecipes = (ArrayList<Recipe>) ViewRecipes.allRecipes;
        recipes.setValue(myRecipes);
    }

    public MutableLiveData<ArrayList<Recipe>> getAllRecipes() {
        return recipes;
    }

    public void setAllRecipes(MutableLiveData<ArrayList<Recipe>> allRecipes) {
        this.recipes = allRecipes;
    }

    public MutableLiveData<Integer> getIndex() {
        return index;
    }

    public void setIndex(MutableLiveData<Integer> index) {
        this.index = index;
    }

    public MutableLiveData<Integer> getItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(MutableLiveData<Integer> itemSelected) {
        this.itemSelected = itemSelected;
    }

    public static RecipesViewModel getInstance(Application application, Context context, Activity activity){
        if(instance == null){
            instance = new RecipesViewModel(application, context, activity);
        }
        return instance;
    }
}
