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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    private static String filePath;
    public static final String fileName = "remove_countries.txt";

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

        boolean remember = prefManager.getBoolean("rememberCB", false);
        filePath = context.getFilesDir().getAbsolutePath();
        removed_countries = new ArrayList<>();

        //raw-file
        StringBuilder text = null;
        String line;

        //Get the text file
        File file = new File(filePath, File.separator + fileName);

        try {
            if(!file.exists())
                file.createNewFile();

            //read text from file
            InputStream inputStream = new FileInputStream(file);
            text = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null){
                text.append(line);
                text.append('\n');
            }

            inputStream.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //end-raw-file

        if(remember == true) {
            for(Country country : allcountries) {
                if(!removed_countries.contains(country))
                    countriesTemp.add(country);
            }
        }
        else {
            /*//shared-preferences
            editor.clear();
            editor.commit();
            //end-shared-preferences*/

            //raw-file
            try{
                FileOutputStream writer = new FileOutputStream(filePath+ File.separator + fileName);
                writer.write(("".getBytes()));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //end-raw-file
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
        Country countryPos = allcountries.get(position);
        holder.countryName.setText(countryPos.getName());
        holder.countryPopulation.setText(countryPos.getShorty());
        holder.countryFlag.setImageResource(context.getResources().getIdentifier(countryPos.flag,"drawable",context.getPackageName()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /*//shared-preferences
                editor.putString(countryPos.getName(), countryPos.getName());
                editor.commit();
                //end-shared-preferences*/

                //raw-file
                File directory = new File(filePath);
                if(!directory.exists())
                    directory.mkdir();
                File newFile = new File(filePath, File.separator + fileName);
                try {
                    if(!newFile.exists())
                        newFile.createNewFile();

                    FileOutputStream fout = new FileOutputStream(newFile, true);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fout);
                    outputWriter.write(countryPos.getName() + "\n");
                    outputWriter.close();
                }catch (Exception e) {
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
