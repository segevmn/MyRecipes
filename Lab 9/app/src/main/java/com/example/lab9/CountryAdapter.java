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
    public static AdapterListener adapterListener;

    public CountryAdapter(AdapterListener adapterListener, Context context, ArrayList<Country> allcountries){
        this.adapterListener = adapterListener;
        this.context = context;
        this.allcountries = allcountries;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewCountry = inflater.inflate(R.layout.row_item,parent,false);
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
        Country country = allcountries.get(position);
        holder.countryName.setText(country.getName());
        holder.countryPopulation.setText(country.getShorty());
        holder.countryFlag.setImageResource(context.getResources().getIdentifier(country.flag,"drawable",context.getPackageName()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //raw-file
                //model.writeData(model.getCountry().getValue().get(position).getName());
                //end-raw-file

                //shared-preferences
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(country.getName(), country.getName());
                editor.commit();
                //end-shared-preferences

                allcountries.remove(country);
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
