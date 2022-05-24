package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;



public class MainActivity extends AppCompatActivity implements CountryFragment.CountryListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}