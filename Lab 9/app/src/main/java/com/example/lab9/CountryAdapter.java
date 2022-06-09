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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    public static final String FileName = "remove_countries.txt";
    public static AdapterListener adapterListener;
    private static ArrayList<String> removed_countries;
    private static String file_path;
    ArrayList<Country> allcountries;
    Context context;
    SharedPreferences prefManager;
    SharedPreferences.Editor editor;
    OutputStream FileOutput;
    InputStream FileInput;
    private ArrayList<Country> countriesTemp;

    public CountryAdapter(AdapterListener adapterListener, Context context, ArrayList<Country> allcountries) {
        CountryAdapter.adapterListener = adapterListener;
        prefManager = PreferenceManager.getDefaultSharedPreferences(context);
        editor = prefManager.edit();
        this.context = context;
        this.allcountries = allcountries;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewCountry = inflater.inflate(R.layout.row_item, parent, false);
        file_path = context.getFilesDir().getAbsolutePath();
        countriesTemp = new ArrayList<Country>();
        StringBuilder text = null;
        String line;
        File file = new File(file_path, File.separator + FileName);
        boolean remember = prefManager.getBoolean("rememberCB", false);

        //raw-file
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInput = new FileInputStream(file);
            text = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(FileInput);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            FileInput.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //removed_countries = new ArrayList<String>(Arrays.asList(text.toString().split("\n")));

        removed_countries = new ArrayList<>();
        for (Map.Entry<String, ?> entry : prefManager.getAll().entrySet()) {
            if (entry.getValue() instanceof String) {
                removed_countries.add(String.valueOf(entry.getValue()));
            }
        }

        if (remember == true) {
            for (Country country : allcountries) {
                if (!removed_countries.contains(country.getName())) {
                    countriesTemp.add(country);
                }
            }
            allcountries = countriesTemp;
        } else {
            try {
                FileOutput = new FileOutputStream(file_path + File.separator + FileName);
                FileOutput.write(("".getBytes()));
                FileOutput.close();
                removed_countries.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //end-raw-file

            //shared-preferences
            editor = prefManager.edit();
            editor.clear();
            editor.commit();
            //end-shared-preferences
        }
        //end-raw-file

        return new ViewHolder(viewCountry);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country countryPos = allcountries.get(position);
        holder.countryName.setText(countryPos.getName());
        holder.countryPopulation.setText(countryPos.getShorty());
        holder.countryFlag.setImageResource(context.getResources().getIdentifier(countryPos.flag, "drawable", context.getPackageName()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //raw-file
                File dir = new File(file_path);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File file = new File(file_path, File.separator + FileName);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream FileOut = new FileOutputStream(file, true);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(FileOut);
                    outputWriter.write(countryPos.getName() + "\n");
                    outputWriter.close();
                    removed_countries.add(countryPos.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //end-raw-file

                //shared-preferences
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(countryPos.getName(), countryPos.getName());
                editor.commit();
                //end-shared-preferences

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

    private static class AdapterListener {

    }

    public class pref extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.settings, rootKey);
        }
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
}
