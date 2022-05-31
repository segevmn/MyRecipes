package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements CountryFragment.CountryListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.setting:
                settingDialog exampleD = new settingDialog();
                exampleD.show(getSupportFragmentManager(), "example dialog");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void apply() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new setting())
                .addToBackStack(null)
                .commit();
    }
}