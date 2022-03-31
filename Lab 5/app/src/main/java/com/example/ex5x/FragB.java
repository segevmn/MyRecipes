package com.example.ex5x;

//import android.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragB extends Fragment /*implements SeekBar.OnSeekBarChangeListener*/ {
	private TextView Result;
	private FragBListener listener;
	private SeekBar seekbar;
	float resF;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//seekbar.setProgress(0);
		//seekbar.setOnSeekBarChangeListener(this);
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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_b, container,false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		this.Result = (TextView) view.findViewById(R.id.TV_equal);
		//this.seekbar = (SeekBar) view.findViewById(R.id.seekBar);
	}

	//the activity informs fragB about new click in fragA
	public void display(float input1, float input2, char op, float res) {
		//resF = res;
		Result.setText(String.valueOf(input1) + op + String.valueOf(input2) + "=" + String.valueOf(res));
	}

	public interface FragBListener {
		//put here methods you want to utilize to communicate with the hosting activity
	}

	/*public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		switch (progress) {
			case 0:
				Result.setText(String.format("%.0f", resF));
				break;
			case 1:
				Result.setText(String.format("%.1f", resF));
				break;
			case 2:
				Result.setText(String.format("%.2f", resF));
				break;
			case 3:
				Result.setText(String.format("%.3f", resF));
				break;
			case 4:
				Result.setText(String.format("%.4f", resF));
				break;
			case 5:
				Result.setText(String.format("%.5f", resF));
				break;
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {

	}*/
}
