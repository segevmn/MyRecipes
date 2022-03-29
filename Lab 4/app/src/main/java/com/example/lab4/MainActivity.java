package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);

        operand1.addTextChangedListener(new MyTextWatcher());
        operand2.addTextChangedListener(new MyTextWatcher());

        ViewGroup parentLayout = (ViewGroup)findViewById(R.id.L_calculator);
        View child = getLayoutInflater().inflate(R.layout.seekbar, parentLayout, false);
        parentLayout.addView(child);

        SeekBar seekbar;
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setProgress(0);
        seekbar.setOnSeekBarChangeListener(this);

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
            EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
            EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
            Button add = (Button) findViewById(R.id.B_addition);
            Button sub = (Button) findViewById(R.id.B_subtraction);
            Button mul = (Button) findViewById(R.id.B_multiplication);
            Button div = (Button) findViewById(R.id.B_division);

            String op1 = operand1.getText().toString();
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

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        TextView textView = (TextView) findViewById(R.id.TV_seekBar);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        if (progress == 0) {
            int res = (int)Global.result;
            textView.setText("Example:123");
            equal.setText(String.valueOf(res));
        }
        else if(progress == 1) {
            textView.setText("Example:123.0");
            equal.setText(String.format("%.1f", Global.result));
        }
        else if(progress == 2) {
            textView.setText("Example:123.00");
            equal.setText(String.format("%.2f", Global.result));
        }
        else if(progress == 3) {
            textView.setText("Example:123.000");
            equal.setText(String.format("%.3f", Global.result));
        }
        else if(progress == 4) {
            textView.setText("Example:123.0000");
            equal.setText(String.format("%.4f", Global.result));
        }
        else if(progress == 5) {
            textView.setText("Example:123.00000");
            equal.setText(String.format("%.5f", Global.result));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void add(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        float num1 = Integer.parseInt(op1);
        float num2 = Integer.parseInt(op2);
        Global.result = (num1 + num2);
        equal.setText(String.valueOf(Global.result));
    }

    public void sub(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        float num1 = Integer.parseInt(op1);
        float num2 = Integer.parseInt(op2);
        Global.result = (num1 - num2);
        equal.setText(String.valueOf(Global.result));
    }

    public void mul(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        float num1 = Integer.parseInt(op1);
        float num2 = Integer.parseInt(op2);
        Global.result = (num1 * num2);
        equal.setText(String.valueOf(Global.result));
    }

    public void div(View view) {
        EditText operand1 = (EditText) findViewById(R.id.ET_operand1);
        EditText operand2 = (EditText) findViewById(R.id.ET_operand2);
        TextView equal = (TextView) findViewById(R.id.TV_equal);

        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        float num1 = Integer.parseInt(op1);
        float num2 = Integer.parseInt(op2);
        Global.result = (num1 / num2);
        equal.setText(String.valueOf(Global.result));
    }
}