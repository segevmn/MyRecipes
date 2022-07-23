package com.example.myRecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements AddRecipe.AddRecipesListener, ViewRecipes.ViewRecipesListener {
    LinearLayout mainLayout;
    Button addRecipe;
    Button viewRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainLayout = findViewById(R.id.mainLayout);
        addRecipe = findViewById(R.id.addButton);
        viewRecipes = findViewById(R.id.viewButton);

        if (addRecipe != null) {
            addRecipe.setOnClickListener(v -> addRecipe());
        }
        if (viewRecipes != null) {
            viewRecipes.setOnClickListener(v -> viewRecipes());
        }
    }

    public void addRecipe() {
        Fragment addFragment = new AddRecipe();
        FragmentTransaction addTransaction = getSupportFragmentManager().beginTransaction();
        addTransaction.replace(R.id.mainFrameLayout, addFragment);
        addTransaction.addToBackStack(null);
        addTransaction.commit();

        mainLayout.setVisibility(View.GONE);
    }

    public void viewRecipes() {
        Fragment viewFragment = new ViewRecipes();
        FragmentTransaction viewTransaction = getSupportFragmentManager().beginTransaction();
        viewTransaction.replace(R.id.mainFrameLayout, viewFragment);
        viewTransaction.addToBackStack(null);
        viewTransaction.commit();

        mainLayout.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mainLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.exit:
                exitDialog exitDiag = new exitDialog();
                exitDiag.show(getSupportFragmentManager(), "exit Dialog");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
