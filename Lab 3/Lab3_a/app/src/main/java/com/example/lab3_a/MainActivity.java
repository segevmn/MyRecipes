package com.example.lab3_a;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.textView);
        register = (Button)findViewById(R.id.button);
    }

    public void transfer(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(data == null)
            return;
        super.onActivityResult(requestCode, resultCode, data);

        // check the request code
        if(requestCode==1)
        {
            String fname = data.getStringExtra("fname");
            String lname = data.getStringExtra("lname");
            String gender = data.getStringExtra("gender");
            if(gender.equals("female")){
                text.setText("Welcome Back Ms. " + fname + ", " + lname);
            } else{
                text.setText("Welcome Back Mr. " + fname + ", " + lname);
            }
            register.setText("again...");
        }
    }
}