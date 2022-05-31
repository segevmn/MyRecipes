package com.example.lab9;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;

public class setting extends PreferenceFragmentCompat implements CountryFragment.CountryListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
    }
}
