package com.example.lab3_b;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText firstName, latsName;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firstName = (EditText)findViewById(R.id.editText);
        latsName = (EditText)findViewById(R.id.editText1);
        group = (RadioGroup)findViewById(R.id.radiogroup);
    }

    public void backToMain(View view) {
        Intent resultIntent = new Intent();
        if (firstName.getText().toString().isEmpty() || latsName.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Please fill First Name / Last name.",Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedId = group.getCheckedRadioButtonId();

        if (selectedId == R.id.radioButton2) {
            resultIntent.putExtra("gender", "female");
        } else if (selectedId == R.id.radioButton){
            resultIntent.putExtra("gender", "male");
        } else {
            Toast.makeText(getApplicationContext(),"Please Select your gender.",Toast.LENGTH_SHORT).show();
            return;
        }

        resultIntent.putExtra("firstName", firstName.getText().toString());
        resultIntent.putExtra("latsName", latsName.getText().toString());

        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}