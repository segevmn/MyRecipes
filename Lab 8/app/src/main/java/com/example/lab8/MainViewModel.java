package com.example.lab8;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    MutableLiveData<ArrayList<Country>> countryData;
    ArrayList<Country> Countries;
}
