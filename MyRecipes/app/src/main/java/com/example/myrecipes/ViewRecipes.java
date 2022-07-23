package com.example.myRecipes;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewRecipes extends Fragment {
    private ViewRecipesListener listener;

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
        super.onViewCreated(view, savedInstanceState);
    }

    public interface ViewRecipesListener {

    }
}