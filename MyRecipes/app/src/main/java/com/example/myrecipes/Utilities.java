package com.example.myRecipes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Utilities {
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public static void saveString(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences("MyRecipesSharedStorage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences("MyRecipesSharedStorage", Context.MODE_PRIVATE);
        return sharedPref.getString(key, "");
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public static void clearSharedPref(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("MyRecipesSharedStorage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public static void saveList(Context context, List<Recipe> list, String key) {
        SharedPreferences prefs = context.getSharedPreferences("MyRecipesSharedStorage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    public static List<Recipe> getList(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences("MyRecipesSharedStorage", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<List<Recipe>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}