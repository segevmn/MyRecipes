package com.example.lab9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceFragmentCompat;

public class setting extends PreferenceFragmentCompat implements CountryFragment.CountryListener {
    CheckBoxPreference rememberCB;

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(getResources().getColor(R.color.white));
        /* rememberCB = (CheckBoxPreference) findPreference ("rememberCB");
        SharedPreferences sharedPref = getActivity().getSharedPreferences("shared Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("rememberCB", rememberCB.isChecked());*/
    }
}
