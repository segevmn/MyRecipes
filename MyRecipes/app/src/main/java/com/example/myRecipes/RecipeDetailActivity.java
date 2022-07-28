package com.example.myRecipes;

import static com.example.myRecipes.ViewRecipes.allRecipes;
import static java.lang.String.format;
import static java.lang.String.valueOf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity implements View.OnClickListener {
    TextView name, size, progress;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17, checkBox18, checkBox19, checkBox20;
    CheckBox checkBox_1, checkBox_2, checkBox_3, checkBox_4, checkBox_5, checkBox_6, checkBox_7, checkBox_8, checkBox_9, checkBox_10, checkBox_11, checkBox_12, checkBox_13, checkBox_14, checkBox_15, checkBox_16, checkBox_17, checkBox_18, checkBox_19, checkBox_20;
    ProgressBar progressBar;
    int ProgressValue, ProgressMax, IngredientsNum, StepsNum;
    Button btnstartTimer, btnStoptimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        name = findViewById(R.id.nameEditText);
        size = findViewById(R.id.sizeEditText);
        progress = findViewById(R.id.progressTextView);
        btnstartTimer = findViewById(R.id.saveButton);
        btnStoptimer = findViewById(R.id.finishButton);

        progressBar = findViewById(R.id.progressBar);
        ProgressValue = 0;
        progressBar.setProgress(ProgressValue);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox1.setChecked(false);
        checkBox1.setOnClickListener(this);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox2.setChecked(false);
        checkBox2.setOnClickListener(this);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox3.setChecked(false);
        checkBox3.setOnClickListener(this);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox4.setChecked(false);
        checkBox4.setOnClickListener(this);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox5.setChecked(false);
        checkBox5.setOnClickListener(this);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox6.setChecked(false);
        checkBox6.setOnClickListener(this);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox7.setChecked(false);
        checkBox7.setOnClickListener(this);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox8.setChecked(false);
        checkBox8.setOnClickListener(this);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox9.setChecked(false);
        checkBox9.setOnClickListener(this);
        checkBox10 = findViewById(R.id.checkBox10);
        checkBox10.setChecked(false);
        checkBox10.setOnClickListener(this);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox11.setChecked(false);
        checkBox11.setOnClickListener(this);
        checkBox12 = findViewById(R.id.checkBox12);
        checkBox12.setChecked(false);
        checkBox12.setOnClickListener(this);
        checkBox13 = findViewById(R.id.checkBox13);
        checkBox13.setChecked(false);
        checkBox13.setOnClickListener(this);
        checkBox14 = findViewById(R.id.checkBox14);
        checkBox14.setChecked(false);
        checkBox14.setOnClickListener(this);
        checkBox15 = findViewById(R.id.checkBox15);
        checkBox15.setChecked(false);
        checkBox15.setOnClickListener(this);
        checkBox16 = findViewById(R.id.checkBox16);
        checkBox16.setChecked(false);
        checkBox16.setOnClickListener(this);
        checkBox17 = findViewById(R.id.checkBox17);
        checkBox17.setChecked(false);
        checkBox17.setOnClickListener(this);
        checkBox18 = findViewById(R.id.checkBox18);
        checkBox18.setChecked(false);
        checkBox18.setOnClickListener(this);
        checkBox19 = findViewById(R.id.checkBox19);
        checkBox19.setChecked(false);
        checkBox19.setOnClickListener(this);
        checkBox20 = findViewById(R.id.checkBox20);
        checkBox20.setChecked(false);
        checkBox20.setOnClickListener(this);

        // recipe steps
        checkBox_1 = findViewById(R.id.checkBox_1);
        checkBox_1.setChecked(false);
        checkBox_1.setOnClickListener(this);
        checkBox_2 = findViewById(R.id.checkBox_2);
        checkBox_2.setChecked(false);
        checkBox_2.setOnClickListener(this);
        checkBox_3 = findViewById(R.id.checkBox_3);
        checkBox_3.setChecked(false);
        checkBox_3.setOnClickListener(this);
        checkBox_4 = findViewById(R.id.checkBox_4);
        checkBox_4.setChecked(false);
        checkBox_4.setOnClickListener(this);
        checkBox_5 = findViewById(R.id.checkBox_5);
        checkBox_5.setChecked(false);
        checkBox_5.setOnClickListener(this);
        checkBox_6 = findViewById(R.id.checkBox_6);
        checkBox_6.setChecked(false);
        checkBox_6.setOnClickListener(this);
        checkBox_7 = findViewById(R.id.checkBox_7);
        checkBox_7.setChecked(false);
        checkBox_7.setOnClickListener(this);
        checkBox_8 = findViewById(R.id.checkBox_8);
        checkBox_8.setChecked(false);
        checkBox_8.setOnClickListener(this);
        checkBox_9 = findViewById(R.id.checkBox_9);
        checkBox_9.setChecked(false);
        checkBox_9.setOnClickListener(this);
        checkBox_10 = findViewById(R.id.checkBox_10);
        checkBox_10.setChecked(false);
        checkBox_10.setOnClickListener(this);
        checkBox_11 = findViewById(R.id.checkBox_11);
        checkBox_11.setChecked(false);
        checkBox_11.setOnClickListener(this);
        checkBox_12 = findViewById(R.id.checkBox_12);
        checkBox_12.setChecked(false);
        checkBox_12.setOnClickListener(this);
        checkBox_13 = findViewById(R.id.checkBox_13);
        checkBox_13.setChecked(false);
        checkBox_13.setOnClickListener(this);
        checkBox_14 = findViewById(R.id.checkBox_14);
        checkBox_14.setChecked(false);
        checkBox_14.setOnClickListener(this);
        checkBox_15 = findViewById(R.id.checkBox_15);
        checkBox_15.setChecked(false);
        checkBox_15.setOnClickListener(this);
        checkBox_16 = findViewById(R.id.checkBox_16);
        checkBox_16.setChecked(false);
        checkBox_16.setOnClickListener(this);
        checkBox_17 = findViewById(R.id.checkBox_17);
        checkBox_17.setChecked(false);
        checkBox_17.setOnClickListener(this);
        checkBox_18 = findViewById(R.id.checkBox_18);
        checkBox_18.setChecked(false);
        checkBox_18.setOnClickListener(this);
        checkBox_19 = findViewById(R.id.checkBox_19);
        checkBox_19.setChecked(false);
        checkBox_19.setOnClickListener(this);
        checkBox_20 = findViewById(R.id.checkBox_20);
        checkBox_20.setChecked(false);
        checkBox_20.setOnClickListener(this);

        btnstartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService();
            }
        });

        btnStoptimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService();
                Intent intent = new Intent(RecipeDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        int i, index = getIntent().getIntExtra("index", -1);
        Recipe recipe = allRecipes.get(index);
        name.setText(recipe.getRecipe());
        size.setText(valueOf(recipe.getDishSize()));
        progress.setText(format("%d%%", ProgressValue));

        for (i = 0; i <= recipe.getIngredientsList().size() - 1; i++) {
            if (recipe.getIngredientsList().get(i).isEmpty()) {
                IngredientsNum = i;
                break;
            }
        }

        for (i = 0; i <= recipe.getStepsList().size() - 1; i++) {
            if (recipe.getStepsList().get(i).isEmpty()) {
                StepsNum = i;
                break;
            }
        }

        ProgressMax = IngredientsNum + (StepsNum * 10);
        progressBar.setMax(ProgressMax);

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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkBox1:
                if (checkBox1.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox2:
                if (checkBox2.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox3:
                if (checkBox3.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox4:
                if (checkBox4.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox5:
                if (checkBox5.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox6:
                if (checkBox6.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox7:
                if (checkBox7.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox8:
                if (checkBox8.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox9:
                if (checkBox9.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox10:
                if (checkBox10.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox11:
                if (checkBox11.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox12:
                if (checkBox12.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox13:
                if (checkBox13.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox14:
                if (checkBox14.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox15:
                if (checkBox15.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox16:
                if (checkBox16.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox17:
                if (checkBox17.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox18:
                if (checkBox18.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox19:
                if (checkBox19.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox20:
                if (checkBox20.isChecked()) {
                    ProgressValue += 1;
                } else {
                    ProgressValue -= 1;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_1:
                if (checkBox_1.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_2:
                if (checkBox_2.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_3:
                if (checkBox_3.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_4:
                if (checkBox_4.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_5:
                if (checkBox_5.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_6:
                if (checkBox_6.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_7:
                if (checkBox_7.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_8:
                if (checkBox_8.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_9:
                if (checkBox_9.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_10:
                if (checkBox_10.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_11:
                if (checkBox_11.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_12:
                if (checkBox_12.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_13:
                if (checkBox_13.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_14:
                if (checkBox_14.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_15:
                if (checkBox_15.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_16:
                if (checkBox_16.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_17:
                if (checkBox_17.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_18:
                if (checkBox_18.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_19:
                if (checkBox_19.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
            case R.id.checkBox_20:
                if (checkBox_20.isChecked()) {
                    ProgressValue += 10;
                } else {
                    ProgressValue -= 10;
                }
                progressBar.setProgress(ProgressValue);
                progress.setText(format("%d%%", ProgressValue));
                break;
        }
    }

    public void startService(){
        Intent intent = new Intent(this, RecipeTimerService.class);
        startService(intent);
    }

    public void stopService (){
        Intent intent = new Intent(this, RecipeTimerService.class);
        stopService(intent);
    }
}