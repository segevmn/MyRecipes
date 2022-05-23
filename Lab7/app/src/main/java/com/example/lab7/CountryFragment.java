package com.example.lab7;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryFragment extends Fragment {
    CountryListener listener;
    private RecyclerView CountriesecyclerView;
    private CountryAdapter CAdapter;
    ArrayList<Country> countriesData=null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        countriesData=CountryXMLParser.parseCountries(context);
        if (context instanceof CountryListener) {
            listener = (CountryListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implements the interface 'CountrySelectListener'");
        }

    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragmentcountry, container, false);
        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CountriesecyclerView = view.findViewById(R.id.recycler);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CAdapter = new CountryAdapter(getActivity(),countriesData);
        CountriesecyclerView.setAdapter(CAdapter);
        CountriesecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public interface CountryListener {
    }
}
