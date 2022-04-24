package com.example.ex5x;

//import android.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar;

public class FragB extends Fragment implements SeekBar.OnSeekBarChangeListener {
	private TextView Result, example;
	private FragBListener listener;
	private SeekBar seekbar;
	float resF;
	String resS;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(@NonNull Context context) {
		try {
			this.listener = (FragBListener)context;
		} catch(ClassCastException e) {
			throw new ClassCastException("the class " +
					getActivity().getClass().getName() +
					" must implements the interface 'FragBListener'");
		}

		super.onAttach(context);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_b, container,false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		this.Result = (TextView) view.findViewById(R.id.TV_equal);
		this.example = (TextView) view.findViewById(R.id.TV_seekBar);
		this.seekbar = (SeekBar) view.findViewById(R.id.seekBar);
		seekbar.setProgress(0);
		seekbar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) this);
	}

	//the activity informs fragB about new click in fragA
	public void display(float input1, float input2, char op, float res) {
		resF = res;
		resS = String.valueOf(input1) + " " + op + " " + String.valueOf(input2) + " " + "=" + " " + String.format("%.0f", resF);
		Result.setText(resS);
		resS = String.valueOf(input1) + " " + op + " " + String.valueOf(input2) + " " + "=" + " ";
	}

	public interface FragBListener {

	}

	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		switch (progress) {
			case 0:
				Result.setText(resS + String.format("%.0f", resF));
				example.setText("Example:123");
				break;
			case 1:
				Result.setText(resS + String.format("%.1f", resF));
				example.setText("Example:123.0");
				break;
			case 2:
				Result.setText(resS + String.format("%.2f", resF));
				example.setText("Example:123.00");
				break;
			case 3:
				Result.setText(resS + String.format("%.3f", resF));
				example.setText("Example:123.000");
				break;
			case 4:
				Result.setText(resS + String.format("%.4f", resF));
				example.setText("Example:123.0000");
				break;
			case 5:
				Result.setText(resS + String.format("%.5f", resF));
				example.setText("Example:123.00000");
				break;
		}
	}

	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	public void onStopTrackingTouch(SeekBar seekBar) {

	}
}
