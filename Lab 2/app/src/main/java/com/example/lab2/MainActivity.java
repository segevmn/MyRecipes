package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        Log.i("onCreate", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart", "onStart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("onSaveInstanceState", "onSaveInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop", "onStop");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("onRestoreInstanceState", "onRestoreInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "onDestroy");
    }

    public void add(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        if (op1.isEmpty() || op2.isEmpty()) {
            Toast.makeText(this, "You must fill bout operands", Toast.LENGTH_LONG).show();
        } else {
            int num1 = Integer.parseInt(op1);
            int num2 = Integer.parseInt(op2);
            equal.setText(String.valueOf(num1 + num2));
        }
    }

    public void sub(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        if (op1.matches("") || op2.matches("")) {
            Toast.makeText(this, "You must fill bout operands", Toast.LENGTH_LONG).show();
        } else {
            int num1 = Integer.parseInt(op1);
            int num2 = Integer.parseInt(op2);
            equal.setText(String.valueOf(num1 - num2));
        }
    }

    public void mul(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        if (op1.isEmpty() || op2.isEmpty()) {
            Toast.makeText(this, "You must fill bout operands", Toast.LENGTH_LONG).show();
        } else {
            int num1 = Integer.parseInt(op1);
            int num2 = Integer.parseInt(op2);
            equal.setText(String.valueOf(num1 * num2));
        }
    }

    public void div(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        if (op1.matches("") || op2.matches("")) {
            Toast.makeText(this, "You must fill bout operands", Toast.LENGTH_LONG).show();
        } else {
            if (op2.matches("0")) {
                Toast.makeText(this, "You can't divide by 0", Toast.LENGTH_LONG).show();
            } else {
                int num1 = Integer.parseInt(op1);
                int num2 = Integer.parseInt(op2);
                equal.setText(String.valueOf(num1 / num2));
            }
        }
    }
}