package com.example.myRecipes;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataBaseService extends SQLiteOpenHelper {
    public static final String DBName = "Recipe_Database";
    public static final String TABLERECIPE = "Recipe";

    public static final String Col_1 = "RecipeData";
    public static final String Col_2 = "RecipeDataId";
    public static ArrayList<String> arrayListId = new ArrayList<String>();

    public DataBaseService(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create Recipe of terms
        db.execSQL(" create table " + TABLERECIPE + "(" + Col_1 + " TEXT," + Col_2 + " INTEGER PRIMARY KEY AUTOINCREMENT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLERECIPE);
        onCreate(db);
    }

    // function to add term into database
    public void AddRecipe(List<Recipe> modelList) {
        Gson gson = new Gson();
        String json = gson.toJson(modelList);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Col_1, json);
        long result = db.insert(TABLERECIPE, null, cv);
        if (result == -1) {
            Log.e(TAG, "value not inserted");
        } else {
            Log.e(TAG, "value inserted");
        }
        db.close();
    }

    // function to delete  course data
    public void DeleteRecipeData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLERECIPE, "RecipeDataId=?", new String[]{id});
    }

    // function to get data from database
    public List<Recipe> getRecipeData() {
        List<Recipe> dataList1 = new ArrayList<Recipe>();
        arrayListId.clear();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLERECIPE, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Gson gson = new Gson();
            String json = cursor.getString(0);
            arrayListId.add(String.valueOf(cursor.getInt(1)));
            Type type = new TypeToken<List<Recipe>>() {
            }.getType();
            List<Recipe> dataList = gson.fromJson(json, type);
            dataList1.add(new Recipe(dataList));
            cursor.moveToNext();
        }
        return dataList1;
    }
}