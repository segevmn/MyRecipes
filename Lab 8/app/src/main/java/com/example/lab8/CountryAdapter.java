package com.example.lab8;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    ArrayList<Country> allcountries;
    MainViewModel countriesView;
    int SelectedCountryIndex=RecyclerView.NO_POSITION;
    Context context;
    Application application;


    public CountryAdapter(Application application, Context context, Activity activity) {
        countriesView= MainViewModel.getInstance(application,context,activity);
        this.allcountries=countriesView.getCountryData().getValue();
        this.context = context;
        this.application = application;

    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewCountry = inflater.inflate(R.layout.row_item,parent,false);
        return new ViewHolder(viewCountry);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Country country = allcountries.get(position);
        Observer<Integer> observeselectedCountryIndex = new Observer<Integer>() {
            @Override
            public void onChanged(Integer countryindex) {
                SelectedCountryIndex = countryindex;
            }
        };
        countriesView.getIndex().observe((LifecycleOwner)context,observeselectedCountryIndex);
        if (SelectedCountryIndex==position){
            holder.itemView.setBackgroundColor(Color.WHITE);
        }
        else holder.itemView.setBackgroundColor(Color.parseColor("#00DDFF"));

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int countryPosition = holder.getAdapterPosition();
                allcountries.remove(countryPosition);
                countriesView.setCountryData(allcountries);
                if(countryPosition < SelectedCountryIndex)
                {
                    SelectedCountryIndex--;
                    countriesView.setIndex(SelectedCountryIndex);
                }
                else if (countryPosition == SelectedCountryIndex)
                {
                    SelectedCountryIndex = RecyclerView.NO_POSITION;
                    countriesView.setItemSelected(null);
                    countriesView.setIndex(RecyclerView.NO_POSITION);
                }
                notifyDataSetChanged();
                return true;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectedCountryIndex = position;
                notifyItemChanged(SelectedCountryIndex);
                notifyDataSetChanged();
                countriesView.setItemSelected(country);
                countriesView.setIndex(SelectedCountryIndex);
                CountryDetailsFragment fragDetails;
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                if (activity.getResources().getConfiguration() .orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    fragDetails = new CountryDetailsFragment();
                    activity.getSupportFragmentManager().beginTransaction().add(R.id.fragContainer,fragDetails)
                            .addToBackStack("BBB").commit();
                }
            }
        });
        holder.bindCountryData(country);
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
            context=itemView.getContext();
            this.itemView = itemView.findViewById(R.id.row_country);
            countryName = (TextView) itemView.findViewById(R.id.countryName);
            countryPopulation = (TextView) itemView.findViewById(R.id.countryPopulation);
            countryFlag = (ImageView) itemView.findViewById(R.id.flag);

        }
        public void  bindCountryData(Country country){
            countryName.setText(country.getName());
            countryPopulation.setText(country.getShorty());
            countryFlag.setImageResource(context.getResources().getIdentifier(country.flag,"drawable",context.getPackageName()));
        }

    }

}
