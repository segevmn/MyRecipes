package com.example.myrecipes;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ViewRecipes extends Fragment {
    private ViewRecipesListener listener;
    private RecyclerView menus;
    private MenuAdapter MAdapter;
    ArrayList<Recipe> allRecipes = null;

    public ViewRecipes() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        try {
            this.listener = (ViewRecipesListener)context;
        } catch(ClassCastException e) {
            throw new ClassCastException("the class " +
                    getActivity().getClass().getName() +
                    " must implements the interface 'ViewRecipesListener'");
        }

        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_recipes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        menus = view.findViewById(R.id.recycler);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        MAdapter = new MenuAdapter(getActivity());
        menus.setAdapter(MAdapter);
        menus.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    public interface ViewRecipesListener {

    }
}