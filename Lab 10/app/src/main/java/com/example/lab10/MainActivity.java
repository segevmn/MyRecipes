package com.example.lab10;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    private static final int Permission_Request_Code = 1;
    private MyBroadcastReceiver broad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broad = new MyBroadcastReceiver();
        // for sms received
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, Permission_Request_Code);
    }

    // for sms received
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, int[] grantResults) {
        if (requestCode == Permission_Request_Code) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "SMS Receive/read Permissions granted", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "You need to grant this permission to Receive/read SMS messages", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    // for network availability
    @Override
    protected void onResume() {
        IntentFilter intent = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.registerReceiver(broad, intent, Manifest.permission.ACCESS_NETWORK_STATE, null);
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(broad);
        super.onPause();
    }
}