package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CountryFragment.CountryListener, CountryDetailsFragment.CountryDetailsListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CountryDetailsFragment cdFrag = (CountryDetailsFragment) getSupportFragmentManager().findFragmentByTag("COUNTRYDETAILSFRAGMENT");
        if ((getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)){
            if (cdFrag != null) {
                getSupportFragmentManager().beginTransaction()
                        .show(cdFrag)
                        .commit();
            }
            else {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragContainer, CountryDetailsFragment.class, null, "COUNTRYDETAILSFRAGMENT")
                        .commit();
            }
        }
        getSupportFragmentManager().executePendingTransactions();
    }

    @Override
    public void  OnClickEvent (Country country) {
        CountryDetailsFragment cdFrag;
        if ((getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragContainer, CountryDetailsFragment.class, null, "COUNTRYDETAILSFRAGMENT")
                    .addToBackStack("BBB")
                    .commit();
            getSupportFragmentManager().executePendingTransactions();
        }
        cdFrag = (CountryDetailsFragment) getSupportFragmentManager().findFragmentByTag("COUNTRYDETAILSFRAGMENT");
        cdFrag.details(country);
    }
}