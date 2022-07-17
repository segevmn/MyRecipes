package com.example.myrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MenusFragment.MenuListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MenuDetailsFragment detailsFragment = (MenuDetailsFragment) getSupportFragmentManager().findFragmentByTag("menudetailsfrag");
        if((getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)){
            if(detailsFragment != null) {
                getSupportFragmentManager().beginTransaction().show(detailsFragment).commit();
            } else {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frag, MenuDetailsFragment.class, null, "menudetailsfrag")
                        .addToBackStack("BBB").commit();
            }
        }
    }
}