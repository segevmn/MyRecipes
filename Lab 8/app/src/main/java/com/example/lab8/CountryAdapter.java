package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    ArrayList<Country> allcountries;
    Context context;

    public CountryAdapter(Context context, ArrayList<Country> allcountries) {
        this.context = context;
        this.allcountries = allcountries;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewCountry = inflater.inflate(R.layout.row_item,parent,false);
        return new ViewHolder(viewCountry);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = allcountries.get(position);
        holder.countryName.setText(country.getName());
        holder.countryPopulation.setText(country.getShorty());
        holder.countryFlag.setImageResource(context.getResources().getIdentifier(country.flag,"drawable",context.getPackageName()));
        holder.countryDetails.setText(country.getDetails());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                allcountries.remove(country);
                notifyDataSetChanged();
                return true;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        public TextView countryDetails;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            countryName = (TextView) itemView.findViewById(R.id.countryName);
            countryPopulation = (TextView) itemView.findViewById(R.id.countryPopulation);
            countryFlag = (ImageView) itemView.findViewById(R.id.flag);
        }
    }
}
