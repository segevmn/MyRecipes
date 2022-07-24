package com.example.myRecipes;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    String msg;

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case "android.intent.action.BATTERY_LOW":
                msg = "Your battery is low! Charge your device to continue!";
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                break;
        }
    }
}