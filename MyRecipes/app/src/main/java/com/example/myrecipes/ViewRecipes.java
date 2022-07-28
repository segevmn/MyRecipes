package com.example.myRecipes;

import static com.example.myRecipes.DataBaseService.arrayListId;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewRecipes extends Fragment {
    public static List<Recipe> allRecipes = null;
    DataBaseService dataBaseService;
    private RecyclerView menus;
    private MenuAdapter MAdapter;

    public ViewRecipes() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_recipes, container, false);
        allRecipes = new ArrayList<>();
        menus = view.findViewById(R.id.recycler);
        menus.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        //allRecipes = Utilities.getList(context, "recipeList");
        dataBaseService = new DataBaseService(getContext());
        getData();
        return view;
    }

    public void getData() {
        allRecipes = dataBaseService.getRecipeData();
        MAdapter = new MenuAdapter(getActivity().getApplication(),getContext(),getActivity());
        menus.setAdapter(MAdapter);
        MAdapter.notifyDataSetChanged();
    }

    public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
        List<Recipe> myRecipes;
        RecipesViewModel recipesView;

        public MenuAdapter(Application application, Context context, Activity activity) {
            recipesView = RecipesViewModel.getInstance(application,context,activity);
            this.myRecipes = allRecipes;
        }

        @NonNull
        @Override
        public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View viewRecipe = LayoutInflater.from(getContext()).inflate(R.layout.recipe_item, parent, false);
            return new MenuAdapter.ViewHolder(viewRecipe);
        }

        @Override
        public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            Recipe recipe = myRecipes.get(position);
            holder.recipeName.setText(recipe.getRecipe());
            holder.dishSize.setText(String.valueOf(recipe.getDishSize()));
            holder.recipeItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    dataBaseService.DeleteRecipeData(arrayListId.get(position));
                    getData();
                    return true;
                }
            });
            holder.recipeItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getContext().startActivity(new Intent(getContext(), RecipeDetailActivity.class)
                            .putExtra("index", position));
                }
            });
        }

        @Override
        public int getItemCount() {
            return myRecipes != null ? myRecipes.size() : 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView recipeName;
            public TextView dishSize;
            View itemView;
            LinearLayout recipeItem;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                this.itemView = itemView;
                recipeName = itemView.findViewById(R.id.RecipeName);
                dishSize = itemView.findViewById(R.id.DishSize);
                recipeItem = itemView.findViewById(R.id.recipeItem);
            }
        }
    }
}