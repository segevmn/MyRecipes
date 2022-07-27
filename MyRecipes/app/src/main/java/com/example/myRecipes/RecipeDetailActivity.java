package com.example.myRecipes;

import static com.example.myRecipes.ViewRecipes.allRecipes;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myRecipes.R;
import com.example.myRecipes.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {
    TextView name, size;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17, checkBox18, checkBox19, checkBox20;
    CheckBox checkBox_1, checkBox_2, checkBox_3, checkBox_4, checkBox_5, checkBox_6, checkBox_7, checkBox_8, checkBox_9, checkBox_10, checkBox_11, checkBox_12, checkBox_13, checkBox_14, checkBox_15, checkBox_16, checkBox_17, checkBox_18, checkBox_19, checkBox_20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        name = findViewById(R.id.nameEditText);
        size = findViewById(R.id.sizeEditText);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox1.setChecked(false);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox2.setChecked(false);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox3.setChecked(false);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox4.setChecked(false);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox5.setChecked(false);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox6.setChecked(false);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox7.setChecked(false);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox8.setChecked(false);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox9.setChecked(false);
        checkBox10 = findViewById(R.id.checkBox10);
        checkBox10.setChecked(false);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox11.setChecked(false);
        checkBox12 = findViewById(R.id.checkBox12);
        checkBox12.setChecked(false);
        checkBox13 = findViewById(R.id.checkBox13);
        checkBox13.setChecked(false);
        checkBox14 = findViewById(R.id.checkBox14);
        checkBox14.setChecked(false);
        checkBox15 = findViewById(R.id.checkBox15);
        checkBox15.setChecked(false);
        checkBox16 = findViewById(R.id.checkBox16);
        checkBox16.setChecked(false);
        checkBox17 = findViewById(R.id.checkBox17);
        checkBox17.setChecked(false);
        checkBox18 = findViewById(R.id.checkBox18);
        checkBox18.setChecked(false);
        checkBox19 = findViewById(R.id.checkBox19);
        checkBox19.setChecked(false);
        checkBox20 = findViewById(R.id.checkBox20);
        checkBox20.setChecked(false);

        // recipe steps
        checkBox_1 = findViewById(R.id.checkBox_1);
        checkBox_1.setChecked(false);
        checkBox_2 = findViewById(R.id.checkBox_2);
        checkBox_2.setChecked(false);
        checkBox_3 = findViewById(R.id.checkBox_3);
        checkBox_3.setChecked(false);
        checkBox_4 = findViewById(R.id.checkBox_4);
        checkBox_4.setChecked(false);
        checkBox_5 = findViewById(R.id.checkBox_5);
        checkBox_5.setChecked(false);
        checkBox_6 = findViewById(R.id.checkBox_6);
        checkBox_6.setChecked(false);
        checkBox_7 = findViewById(R.id.checkBox_7);
        checkBox_7.setChecked(false);
        checkBox_8 = findViewById(R.id.checkBox_8);
        checkBox_8.setChecked(false);
        checkBox_9 = findViewById(R.id.checkBox_9);
        checkBox_9.setChecked(false);
        checkBox_10 = findViewById(R.id.checkBox_10);
        checkBox_10.setChecked(false);
        checkBox_11 = findViewById(R.id.checkBox_11);
        checkBox_11.setChecked(false);
        checkBox_12 = findViewById(R.id.checkBox_12);
        checkBox_12.setChecked(false);
        checkBox_13 = findViewById(R.id.checkBox_13);
        checkBox_13.setChecked(false);
        checkBox_14 = findViewById(R.id.checkBox_14);
        checkBox_14.setChecked(false);
        checkBox_15 = findViewById(R.id.checkBox_15);
        checkBox_15.setChecked(false);
        checkBox_16 = findViewById(R.id.checkBox_16);
        checkBox_16.setChecked(false);
        checkBox_17 = findViewById(R.id.checkBox_17);
        checkBox_17.setChecked(false);
        checkBox_18 = findViewById(R.id.checkBox_18);
        checkBox_18.setChecked(false);
        checkBox_19 = findViewById(R.id.checkBox_19);
        checkBox_19.setChecked(false);
        checkBox_20 = findViewById(R.id.checkBox_20);
        checkBox_20.setChecked(false);
    }

    @Override
    protected void onStart() {
        int index = getIntent().getIntExtra("index", -1);
        Recipe recipe = allRecipes.get(index);
        name.setText(recipe.getRecipe());
        size.setText(String.valueOf(recipe.getDishSize()));

        checkBox1.setText(recipe.getIngredientsList().get(0));
        checkBox2.setText(recipe.getIngredientsList().get(1));
        checkBox3.setText(recipe.getIngredientsList().get(2));
        checkBox4.setText(recipe.getIngredientsList().get(3));
        checkBox5.setText(recipe.getIngredientsList().get(4));
        checkBox6.setText(recipe.getIngredientsList().get(5));
        checkBox7.setText(recipe.getIngredientsList().get(6));
        checkBox8.setText(recipe.getIngredientsList().get(7));
        checkBox9.setText(recipe.getIngredientsList().get(8));
        checkBox10.setText(recipe.getIngredientsList().get(9));
        checkBox11.setText(recipe.getIngredientsList().get(10));
        checkBox12.setText(recipe.getIngredientsList().get(11));
        checkBox13.setText(recipe.getIngredientsList().get(12));
        checkBox14.setText(recipe.getIngredientsList().get(13));
        checkBox15.setText(recipe.getIngredientsList().get(14));
        checkBox16.setText(recipe.getIngredientsList().get(15));
        checkBox17.setText(recipe.getIngredientsList().get(16));
        checkBox18.setText(recipe.getIngredientsList().get(17));
        checkBox19.setText(recipe.getIngredientsList().get(18));
        checkBox20.setText(recipe.getIngredientsList().get(19));

        // recipe steps
        checkBox_1.setText(recipe.getStepsList().get(0));
        checkBox_2.setText(recipe.getStepsList().get(1));
        checkBox_3.setText(recipe.getStepsList().get(2));
        checkBox_4.setText(recipe.getStepsList().get(3));
        checkBox_5.setText(recipe.getStepsList().get(4));
        checkBox_6.setText(recipe.getStepsList().get(5));
        checkBox_7.setText(recipe.getStepsList().get(6));
        checkBox_8.setText(recipe.getStepsList().get(7));
        checkBox_9.setText(recipe.getStepsList().get(8));
        checkBox_10.setText(recipe.getStepsList().get(9));
        checkBox_11.setText(recipe.getStepsList().get(10));
        checkBox_12.setText(recipe.getStepsList().get(11));
        checkBox_13.setText(recipe.getStepsList().get(12));
        checkBox_14.setText(recipe.getStepsList().get(13));
        checkBox_15.setText(recipe.getStepsList().get(14));
        checkBox_16.setText(recipe.getStepsList().get(15));
        checkBox_17.setText(recipe.getStepsList().get(16));
        checkBox_18.setText(recipe.getStepsList().get(17));
        checkBox_19.setText(recipe.getStepsList().get(18));
        checkBox_20.setText(recipe.getStepsList().get(19));
        super.onStart();
    }
}