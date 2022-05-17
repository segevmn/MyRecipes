package com.example.lab6;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class settingDialog extends DialogFragment implements SeekBar.OnSeekBarChangeListener, TextView.OnEditorActionListener, FragB.FragBListener {
    public DialogListener listener;
    SeekBar seekBar;
    TextView exampleText;
    static int seekBarProgress = 0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.seekbar, null);

        exampleText = view.findViewById(R.id.TV_seekBar);
        seekBar = view.findViewById(R.id.seekBar);
        seekBar.setProgress(0);
        seekBar.setOnSeekBarChangeListener(this);

        builder.setView(view)
                .setTitle("Set the numbers precision");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface DialogInterface, int which) {
                ((MainActivity)getActivity()).applySeekBar(seekBarProgress);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface DialogInterface, int which) {
                DialogInterface.dismiss();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekBarProgress = progress;
        if (seekBarProgress == 0)
            exampleText.setText("Example: 123");
        else {
            exampleText.setText("Example: 123.");
            for (int i = 0; i < seekBarProgress; i++)
                exampleText.append("0");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public interface DialogListener {
        void applySeekBar(int seekBarProgress);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
