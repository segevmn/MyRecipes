package com.example.lab3_client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
        number=(EditText)findViewById(R.id.editText);
        web=(EditText)findViewById(R.id.editText1);
        mail=(EditText)findViewById(R.id.editText2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(data == null)
            return;

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            String fname = data.getStringExtra("fname");
            String lname = data.getStringExtra("lname");
            String gender = data.getStringExtra("gender");
            if(gender.equals("female")){
                Reg.setText("Ms. " + fname + ", " + lname);
            } else{
                Reg.setText("Mr. " + fname + ", " + lname);
            }
        }
    }

    public void SelectReg(View view) {
        Intent intent = new Intent("com.action.Lab3.Register");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,1);
        } else{
            Toast.makeText(getApplicationContext(),"No application found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void email(View view) {
        if(mail.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Please Fill mail.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, mail.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, "mail body");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, ""));
        } else{
            Toast.makeText(getApplicationContext(),"No application found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void surf(View view) {
        String url;

        if(web.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Please Fill website url.", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if ((!web.getText().toString().startsWith("http://")) && (!web.getText().toString().startsWith("https://"))) {
            url = "http://" + web.getText().toString();
        } else {
            url = web.getText().toString();
        }

        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(url));
        if (browserIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(browserIntent);
        } else{
            Toast.makeText(getApplicationContext(),"No application found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri telephone = Uri.parse("tel:" + number.getText().toString());
        intent.setData(telephone);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else{
            Toast.makeText(getApplicationContext(),"No application found!", Toast.LENGTH_SHORT).show();
        }
    }
}