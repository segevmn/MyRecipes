package com.example.myRecipes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addRecipe;
    Button viewRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addRecipe = findViewById(R.id.addButton);
        viewRecipes = findViewById(R.id.viewButton);

        if (addRecipe != null) {
            addRecipe.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    add();
                }
            });
        }
    }

    public void add() {
        getSupportFragmentManager().beginTransaction().replace(R.id.addRecipe, new AddRecipes()).commit();
    }
}
