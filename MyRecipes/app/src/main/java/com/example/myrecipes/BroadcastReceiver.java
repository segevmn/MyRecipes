package com.example.myRecipes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    String msg;
    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        switch (intent.getAction()) {
            case "android.intent.action.BATTERY_LOW":
                msg = "Your battery is low! Charge your device to continue!";
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                showAlert();
                break;
        }
    }

    public void showAlert() {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(context);
        builder.setMessage("Your battery is low! Charge your device to continue!")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        builder.setCancelable(false);
        AlertDialog alert = builder.create();
        alert.setTitle("Charging Alert");
        alert.show();
    }
}