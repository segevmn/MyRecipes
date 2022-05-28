package com.example.lab8;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CountryDetailsFragment extends Fragment {
    CountryDetailsListener listener;
    private TextView Details;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        try {
            this.listener = (CountryDetailsListener)context;
        } catch(ClassCastException e) {
            throw new ClassCastException("the class " +
                    getActivity().getClass().getName() +
                    " must implements the interface 'CountryDetailsListener'");
        }
        super.onAttach(context);
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.country_details_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.Details = (TextView) view.findViewById(R.id.countryDetails);
    }

    public void details (Country country){
        Details.setText(country.getDetails());
    }

    public  interface CountryDetailsListener {

    }
}
