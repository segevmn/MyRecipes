package com.example.lab3_a;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText fname, lname;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fname = (EditText)findViewById(R.id.editText);
        lname = (EditText)findViewById(R.id.editText1);
        group = (RadioGroup)findViewById(R.id.radiogroup);
    }

    public void backToMain(View view) {
        Intent resultIntent = new Intent();
        if(fname.getText().toString().isEmpty() || lname.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Please fill First Name / Last name.",Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedId= group.getCheckedRadioButtonId();

        if(selectedId == R.id.radioButton2){
            resultIntent.putExtra("gender", "female");
        } else if(selectedId == R.id.radioButton){
            resultIntent.putExtra("gender", "male");
        } else{
            Toast.makeText(getApplicationContext(),"Please Select your gender.",Toast.LENGTH_SHORT).show();
            return;
        }

        resultIntent.putExtra("fname", fname.getText().toString());
        resultIntent.putExtra("lname", lname.getText().toString());

        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}