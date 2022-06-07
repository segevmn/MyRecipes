package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity<orientation> extends AppCompatActivity implements CountryFragment.CountryListener   {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryDetailsFragment detailsfrag = (CountryDetailsFragment) getSupportFragmentManager().findFragmentByTag("detailsfrag");
        if ((getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)) {
            if (detailsfrag != null) {
                getSupportFragmentManager().beginTransaction()
                        .show(detailsfrag)
                        .commit();
            } else {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragContainer, CountryDetailsFragment.class, null, "detailsfrag")
                        .addToBackStack("BBB")
                        .commit();
            }
            getSupportFragmentManager().executePendingTransactions();
        }
    }

}