package com.example.lab9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    ArrayList<Country> allcountries;
    Context context;
    Country countryPos;
    public static AdapterListener adapterListener;
    private static ArrayList<String> removed_countries;
    private ArrayList<Country> countriesTemp;

    public CountryAdapter(AdapterListener adapterListener, Context context, ArrayList<Country> allcountries){
        this.adapterListener = adapterListener;
        this.context = context;
        this.allcountries = allcountries;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewCountry = inflater.inflate(R.layout.row_item,parent,false);
        countriesTemp = new ArrayList<Country>();

        //shared-preferences
        SharedPreferences prefManager = PreferenceManager.getDefaultSharedPreferences(context);
        boolean remember = prefManager.getBoolean("rememberCB", false);
        //end-shared-preferences

        removed_countries = new ArrayList<>();
        if(remember == true) {
            for(Country country : allcountries) {
                if(!removed_countries.contains(country))
                    countriesTemp.add(country);
            }
        }
        else {
            //shared-preferences
            SharedPreferences.Editor editor = prefManager.edit();
            editor.clear();
            editor.commit();
            //end-shared-preferences
        }
        return new ViewHolder(viewCountry);
    }

    public class pref extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.settings, rootKey);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        countryPos = allcountries.get(position);
        holder.countryName.setText(countryPos.getName());
        holder.countryPopulation.setText(countryPos.getShorty());
        holder.countryFlag.setImageResource(context.getResources().getIdentifier(countryPos.flag,"drawable",context.getPackageName()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // shared-preferences
                removed_countries.add(String.valueOf(countryPos));
                // end-shared-preferences

                allcountries.remove(countryPos);
                notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.allcountries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView countryName;
        public TextView countryPopulation;
        public ImageView countryFlag;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            countryName = (TextView) itemView.findViewById(R.id.countryName);
            countryPopulation = (TextView) itemView.findViewById(R.id.countryPopulation);
            countryFlag = (ImageView) itemView.findViewById(R.id.flag);
        }
    }

    public interface AdapterListener {
        public void changeFragment();
    }
}
