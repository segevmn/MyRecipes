package com.example.lab3_client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText number;
    EditText web;
    EditText mail;
    TextView Reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (EditText)findViewById(R.id.editText);
        web = (EditText)findViewById(R.id.editText1);
        mail = (EditText)findViewById(R.id.editText2);
        Reg = (TextView)findViewById(R.id.textView1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (data == null) {
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1)
        {
            String firstName = data.getStringExtra("firstName");
            String latsName = data.getStringExtra("latsName");
            String gender = data.getStringExtra("gender");
            if (gender.equals("female")) {
                Reg.setText("Ms. " + firstName + " " + latsName);
            } else {
                Reg.setText("Mr. " + firstName + " " + latsName);
            }
        }
    }

    public void SelectReg(View view) {
        Intent intent = new Intent("com.action.Lab3_Register");
        startActivityForResult(intent,1);
    }

    public void email(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:" + mail.getText().toString()));
        intent.putExtra(Intent.EXTRA_SUBJECT, "this is the Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "this is the body");
        startActivity(intent);
    }

    public void surf(View view) {
        if (web.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Please Fill website url.", Toast.LENGTH_SHORT).show();
            return;
        }

        Uri webpage = Uri.parse(web.getText().toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri telephone = Uri.parse("tel:" + number.getText().toString());
        intent.setData(telephone);
        startActivity(intent);
    }
}