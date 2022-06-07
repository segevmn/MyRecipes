package com.example.lab8;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {
    MutableLiveData<ArrayList<Country>> countryData;
    MutableLiveData<Integer> index;
    MutableLiveData<Country> itemSelected;
    public static MainViewModel VMinstance;

    public MutableLiveData<ArrayList<Country>> getCountryData() {
        return countryData;
    }

    public void setCountryData(ArrayList<Country> countryData) {
        this.countryData.setValue(countryData);
    }

    public MutableLiveData<Integer> getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index.setValue(index);
    }

    public MutableLiveData<Country> getItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(Country itemSelected) {
        this.itemSelected.setValue(itemSelected);
    }

    public MainViewModel (@NonNull Application application, Context context, Activity activity) {
        super(application);
        MutableLiveData <ArrayList<Country>> countryLiveData;
        int ItemSelected;

        countryData = new MutableLiveData<>();
        index = new MutableLiveData<>();
        itemSelected = new MutableLiveData<>();
        index.setValue(RecyclerView.NO_POSITION);
        ArrayList<Country> allcountries = CountryXMLParser.parseCountries(application);
        countryData.setValue(allcountries);
    }

    public static MainViewModel getInstance(Application application, Context context, Activity activity) {
        if(VMinstance == null) {
            VMinstance = new MainViewModel(application, context, activity);
        }
        return VMinstance;
    }
}
