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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    ArrayList<Country> allcountries;
    Context context;
    private static ArrayList<String> removed_countries;
    private ArrayList<Country> countriesTemp;
    public static AdapterListener adapterListener;
    SharedPreferences prefManager;
    SharedPreferences.Editor editor;
    FileOutputStream FileOutput;
    FileInputStream FileInput;
    String FileName = "";

    public CountryAdapter(AdapterListener adapterListener, Context context, ArrayList<Country> allcountries) {
        this.adapterListener = adapterListener;
        prefManager = PreferenceManager.getDefaultSharedPreferences(context);
        editor = prefManager.edit();
        this.context = context;
        this.allcountries = allcountries;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewCountry = inflater.inflate(R.layout.row_item,parent,false);
        countriesTemp = new ArrayList<Country>();
        String line;
        boolean remember = prefManager.getBoolean("rememberCB", false);
        removed_countries = new ArrayList<>();

        //raw-file
        try {
            FileInput = context.openFileInput(String.valueOf(FileInput));
            ByteBuffer bf = ByteBuffer.allocate(500);
            InputStreamReader inputStreamReader = new InputStreamReader(FileInput);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while ((line = bufferedReader.readLine()) != null) {
                removed_countries.add(line);
            }
            FileInput.close();
            inputStreamReader.close();

            if(remember == true) {
                for(Country country : allcountries) {
                    if(!removed_countries.contains(country)) {
                        FileInput.read(bf.array());
                        countriesTemp.add(country);
                    }
                }
                allcountries.addAll(countriesTemp);
            }
            else {
                FileOutput.write(("".getBytes()));
                FileOutput.close();
                removed_countries.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //end-raw-file

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
        Country countryPos = allcountries.get(position);
        holder.countryName.setText(countryPos.getName());
        holder.countryPopulation.setText(countryPos.getShorty());
        holder.countryFlag.setImageResource(context.getResources().getIdentifier(countryPos.flag,"drawable",context.getPackageName()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //raw-file
                try {
                    FileOutput = context.openFileOutput(FileName, context.MODE_PRIVATE);
                    ByteBuffer bf = ByteBuffer.allocate(500);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(FileOutput);
                    outputWriter.write(countryPos.getName().getBytes()+"\n");
                    outputWriter.close();
                    removed_countries.add(countryPos.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //end-raw-file

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

    private static class AdapterListener {
    }
}
