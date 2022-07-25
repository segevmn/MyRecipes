package com.example.myRecipes;

import android.app.Activity;
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
import java.util.List;

public class ViewRecipes extends Fragment {
    private ViewRecipesListener listener;
    private RecyclerView menus;
    private MenuAdapter MAdapter;
    List<Recipe> allRecipes = null;
    Activity context;

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
        View view = inflater.inflate(R.layout.view_recipes, container, false);
        context = getActivity();

        allRecipes = new ArrayList<>();
        menus = view.findViewById(R.id.recycler);

        allRecipes = Utilities.getList(context, "recipeList");
        menus.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        MAdapter = new MenuAdapter(getActivity(), allRecipes);
        menus.setAdapter(MAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public interface ViewRecipesListener {

    }
}