package com.example.myrecipes;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    ArrayList<Menu> AllMenus;
    ArrayList<String> DeletedMenus;
    public static final String FileName = "DeletedMenus.txt";
    Context context;
    SharedPreferences prefs;
    private static String file_path;
    SharedPreferences.Editor prefsEditor;
    InputStream inputFile;
    OutputStream outputFile;
    public static AdapterListener adapterListener;

    public MenuAdapter (AdapterListener adapterListener, Context context, ArrayList<Menu> AllMenus){
        MenuAdapter.adapterListener = adapterListener;
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefsEditor = prefs.edit();
        this.context = context;
        this.AllMenus = AllMenus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewMenu = inflater.inflate(R.layout.menuitem, parent, false);
        file_path = context.getFilesDir().getAbsolutePath();
        StringBuilder text = null;
        String textLine;
        /// recieve a checkbbox value like in lab9
        File file = new File(file_path, File.separator + FileName);

        //Raw-File
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            inputFile = new FileInputStream(file);
            text = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((textLine = bufferedReader.readLine()) != null) {
                text.append(textLine);
                text.append('\n');
            }
            inputFile.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DeletedMenus = new ArrayList<String>(Arrays.asList(text.toString().split("\n")));
        //end Raw-File
        return new ViewHolder(viewMenu);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Menu Menupostition = AllMenus.get(position);
        holder.DishName.setText(Menupostition.getDishName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {//switch fragments
            @Override
            public void onClick(View view) {

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //raw-file
                File directory = new File(file_path);
                if (!directory.exists()) {
                    directory.mkdir();
                }
                File file = new File(file_path, File.separator + FileName);
                try{
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream OutFile = new FileOutputStream(file, true);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(OutFile);
                    outputStreamWriter.write(Menupostition.getDishName() + "\n");
                    outputStreamWriter.close();
                    DeletedMenus.add(Menupostition.getDishName());
                } catch (IOException e){
                    e.printStackTrace();
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.AllMenus.size();
    }

    private static class AdapterListener {

    }


    public  class  ViewHolder extends RecyclerView.ViewHolder{
        public TextView DishName;
        View itemView;

        public ViewHolder(@NonNull View itemview){
            super(itemview);
            this.itemView =itemview;

        }

    }
}
