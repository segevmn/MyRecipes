package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        outState.putString("operand1", operand1.getText().toString());
        outState.putString("operand2", operand2.getText().toString());
        outState.putString("equal", equal.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String operand1 = savedInstanceState.getString("operand1");
        String operand2 = savedInstanceState.getString("operand2");
        String equal = savedInstanceState.getString("equal");
    }

    public void add(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        if (op1.isEmpty() || op2.isEmpty()) {
            Toast.makeText(this, "You must fill both operands", Toast.LENGTH_LONG).show();
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
            Toast.makeText(this, "You must fill both operands", Toast.LENGTH_LONG).show();
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
            Toast.makeText(this, "You must fill both operands", Toast.LENGTH_LONG).show();
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
            Toast.makeText(this, "You must fill both operands", Toast.LENGTH_LONG).show();
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