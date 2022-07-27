package com.example.myRecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class MainActivity extends AppCompatActivity  {
    LinearLayout mainLayout;
    Button addRecipe;
    Button viewRecipes;
    private static final int Permission_Request_Code = 1;
    private BroadcastReceiver broad;

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

        broad = new BroadcastReceiver();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent();
            String packageName = getPackageName();
            PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + packageName));
                startActivity(intent);
            }
        }
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BATTERY_STATS) != PackageManager.PERMISSION_GRANTED)
//            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.BATTERY_STATS}, Permission_Request_Code);
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
            case R.id.home:
                super.onBackPressed();
                mainLayout.setVisibility(View.VISIBLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, int[] grantResults) {
        if (requestCode == Permission_Request_Code) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Battery Receive Permissions granted", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "You need to grant this permission to get an alert when your battery is low", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
