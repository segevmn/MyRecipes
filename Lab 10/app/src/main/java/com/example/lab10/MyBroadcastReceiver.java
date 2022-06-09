package com.example.lab10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    SmsMessage[] smsMSG;
    String sender;
    String smsContent;
    String msg;

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case "android.provider.Telephony.SMS_RECEIVED":
                try {
                    smsMSG = Telephony.Sms.Intents.getMessagesFromIntent(intent);
                } catch (NullPointerException ignored) {
                    return;
                }

                if (smsMSG[0] != null) {
                    sender = "New SMS from: " + smsMSG[0].getDisplayOriginatingAddress();
                    smsContent = "The massage content is: " + smsMSG[0].getDisplayMessageBody();
                    msg = sender + "\n" + smsContent;
                } else
                    msg = "There is Error with the message!";
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                break;

            case "android.net.conn.CONNECTIVITY_CHANGE":
                //Get the network that is running now
                ConnectivityManager con = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkCapabilities actNw = con.getNetworkCapabilities(con.getActiveNetwork());
                //In case there isn't active network actNw will be null
                if (actNw == null)
                    msg = "NETWORK OFF";
                if (actNw != null)
                    msg = "NETWORK ON";
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                break;
        }
    }
}