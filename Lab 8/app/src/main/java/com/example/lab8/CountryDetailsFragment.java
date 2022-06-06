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
import androidx.lifecycle.Observer;

public class CountryDetailsFragment extends Fragment {

    private TextView Details;
    private  MainViewModel countriesVM;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.country_details_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.Details = (TextView) view.findViewById(R.id.countryDetails);
        countriesVM =MainViewModel.getInstance(getActivity().getApplication(),getContext(),getActivity());
        Observer<Country> updateCountriesList = new Observer<Country>() {
            @Override
            public void onChanged(Country country) {
                String detailsSelectedCountry;
                if(country!=null){
                    detailsSelectedCountry=country.getDetails();
                    ((TextView)view.findViewById(R.id.countryDetails)).setText(detailsSelectedCountry.trim().replaceAll("  +", ""));
                }
                else Details.setText(" ");
            }
        };
        countriesVM.getItemSelected().observe(getViewLifecycleOwner(),updateCountriesList);
    }


}
