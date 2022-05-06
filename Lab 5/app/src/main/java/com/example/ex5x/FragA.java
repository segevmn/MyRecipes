package com.example.ex5x;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragA extends Fragment implements OnClickListener {
	FragAListener listener;
	EditText operand1, operand2;
	Button add, sub , mul, div, clear;
	static String op1 = "", op2 = "";

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(@NonNull Context context) {
		try {
			this.listener = (FragAListener)context;
		} catch(ClassCastException e) {
			throw new ClassCastException("the class " +
					context.getClass().getName() +
					" must implements the interface 'FragAListener'");
		}
		super.onAttach(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_a, container,false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		operand1 = (EditText) view.findViewById(R.id.ET_operand1);
		operand2 = (EditText) view.findViewById(R.id.ET_operand2);
		add = (Button) view.findViewById(R.id.B_addition);
		sub = (Button) view.findViewById(R.id.B_subtraction);
		mul = (Button) view.findViewById(R.id.B_multiplication);
		div = (Button) view.findViewById(R.id.B_division);

		// watcher for buttons
		operand1.addTextChangedListener(new MyTextWatcher());
		operand2.addTextChangedListener(new MyTextWatcher());

		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onClickAdd(v);
			}
		});

		sub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onClickSub(v);
			}
		});

		mul.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onClickMul(v);
			}
		});

		div.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onClickDiv(v);
			}
		});
	}

	@Override
	public void onClick(View view) {

	}

	public interface FragAListener {
		public void OnClickEvent(float input1, float input2, int flag);
	}

	public void onClickAdd(View v) {
		op1 = operand1.getText().toString();
		op2 = operand2.getText().toString();
		float num1 = Integer.parseInt(op1);
		float num2 = Integer.parseInt(op2);
		listener.OnClickEvent(num1, num2, 1);
	}

	public void onClickSub(View v) {
		op1 = operand1.getText().toString();
		op2 = operand2.getText().toString();
		float num1 = Integer.parseInt(op1);
		float num2 = Integer.parseInt(op2);
		listener.OnClickEvent(num1, num2, 2);
	}

	public void onClickMul(View v) {
		op1 = operand1.getText().toString();
		op2 = operand2.getText().toString();
		float num1 = Integer.parseInt(op1);
		float num2 = Integer.parseInt(op2);
		listener.OnClickEvent(num1, num2, 3);
	}

	public void onClickDiv(View v) {
		op1 = operand1.getText().toString();
		op2 = operand2.getText().toString();
		float num1 = Integer.parseInt(op1);
		float num2 = Integer.parseInt(op2);
		float i = (num1 / num2);
		Log.i("MyTag", String.valueOf(i));
		listener.OnClickEvent(num1, num2, 4);
	}

	public class MyTextWatcher implements TextWatcher {
		@Override
		public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
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
			String op1 = operand1.getText().toString();
			String op2 = operand2.getText().toString();

			add.setEnabled(false);
			sub.setEnabled(false);
			mul.setEnabled(false);
			div.setEnabled(false);

			if (op1.matches("") || op2.matches("")) {
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
}
