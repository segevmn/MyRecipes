package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        operand1.addTextChangedListener(new MyTextWatcher());
        operand2.addTextChangedListener(new MyTextWatcher());

        SeekBar seekbar;
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setProgress(0);

        //attach an instance of HandleClick to the Button clear
        findViewById(R.id.B_clear).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
                EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
                TextView equal = (TextView) findViewById(R.id.TV_equal);

                operand1.setText("");
                operand2.setText("");
                equal.setText("");
            }
        });
    }

    public class MyTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Button add = (Button) findViewById(R.id.B_addition);
            Button sub = (Button) findViewById(R.id.B_subtraction);
            Button mul = (Button) findViewById(R.id.B_multiplication);
            Button div = (Button) findViewById(R.id.B_division);

            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            Button add = (Button) findViewById(R.id.B_addition);
            Button sub = (Button) findViewById(R.id.B_subtraction);
            Button mul = (Button) findViewById(R.id.B_multiplication);
            Button div = (Button) findViewById(R.id.B_division);

            EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
            String op1 = operand1.getText().toString();
            EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
            String op2 = operand2.getText().toString();

            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);

            if (op1.matches("") && op2.matches("")) {
                add.setEnabled(false);
                sub.setEnabled(false);
                mul.setEnabled(false);
                div.setEnabled(false);
            } else {
                if (op2.matches("0")) {
                    add.setEnabled(true);
                    sub.setEnabled(true);
                    mul.setEnabled(true);
                    div.setEnabled(false);
                } else {
                    add.setEnabled(true);
                    sub.setEnabled(true);
                    mul.setEnabled(true);
                    div.setEnabled(true);
                }
            }
        }
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

        double num1 = Integer.parseInt(op1);
        double num2 = Integer.parseInt(op2);
        equal.setText(String.valueOf(num1 + num2));
    }

    public void sub(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        double num1 = Integer.parseInt(op1);
        double num2 = Integer.parseInt(op2);
        equal.setText(String.valueOf(num1 - num2));
    }

    public void mul(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        double num1 = Integer.parseInt(op1);
        double num2 = Integer.parseInt(op2);
        equal.setText(String.valueOf(num1 * num2));
    }

    public void div(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        double num1 = Integer.parseInt(op1);
        double num2 = Integer.parseInt(op2);
        equal.setText(String.valueOf(num1 / num2));
    }
}