package com.example.myRecipes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class AddRecipe extends Fragment {
    String name;
    Integer size;
    String recipe1 = "", recipe2 = "", recipe3 = "", recipe4 = "", recipe5 = "", recipe6 = "", recipe7 = "", recipe8 = "", recipe9 = "", recipe10 = "", recipe11 = "", recipe12 = "", recipe13 = "", recipe14 = "", recipe15 = "", recipe16 = "", recipe17 = "", recipe18 = "", recipe19 = "", recipe20 = "";
    String recipeStep1 = "", recipeStep2 = "", recipeStep3 = "", recipeStep4 = "", recipeStep5 = "", recipeStep6 = "", recipeStep7 = "", recipeStep8 = "", recipeStep9 = "", recipeStep10 = "", recipeStep11 = "", recipeStep12 = "", recipeStep13 = "", recipeStep14 = "", recipeStep15 = "", recipeStep16 = "", recipeStep17 = "", recipeStep18 = "", recipeStep19 = "", recipeStep20 = "";
    Activity context;
    List<Recipe> modelList;
    List<String> ingredientsList;
    List<String> recipeStepsList;
    DataBaseService dataBaseService;
    boolean saveDataStatus = false;
    EditText nameEditText, sizeEditText, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20;
    EditText editTextStep1, editTextStep2, editTextStep3, editTextStep4, editTextStep5, editTextStep6, editTextStep7, editTextStep8, editTextStep9, editTextStep10, editTextStep11, editTextStep12, editTextStep13, editTextStep14, editTextStep15, editTextStep16, editTextStep17, editTextStep18, editTextStep19, editTextStep20;
    Button btnAddRecipe;

    public AddRecipe() {

    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_recipes, container, false);
        context = getActivity();
        dataBaseService = new DataBaseService(getContext());
        nameEditText = view.findViewById(R.id.nameEditText);
        sizeEditText = view.findViewById(R.id.priceEditText);

        modelList = new ArrayList<>();
        ingredientsList = new ArrayList<>();
        recipeStepsList = new ArrayList<>();

        editText1 = view.findViewById(R.id.editText1);
        editText2 = view.findViewById(R.id.editText2);
        editText3 = view.findViewById(R.id.editText3);
        editText4 = view.findViewById(R.id.editText4);
        editText5 = view.findViewById(R.id.editText5);
        editText6 = view.findViewById(R.id.editText6);
        editText7 = view.findViewById(R.id.editText7);
        editText8 = view.findViewById(R.id.editText8);
        editText9 = view.findViewById(R.id.editText9);
        editText10 = view.findViewById(R.id.editText10);
        editText11 = view.findViewById(R.id.editText11);
        editText12 = view.findViewById(R.id.editText12);
        editText13 = view.findViewById(R.id.editText13);
        editText14 = view.findViewById(R.id.editText14);
        editText15 = view.findViewById(R.id.editText15);
        editText16 = view.findViewById(R.id.editText16);
        editText17 = view.findViewById(R.id.editText17);
        editText18 = view.findViewById(R.id.editText18);
        editText19 = view.findViewById(R.id.editText19);
        editText20 = view.findViewById(R.id.editText20);

        editTextStep1 = view.findViewById(R.id.editTextStep1);
        editTextStep2 = view.findViewById(R.id.editTextStep2);
        editTextStep3 = view.findViewById(R.id.editTextStep3);
        editTextStep4 = view.findViewById(R.id.editTextStep4);
        editTextStep5 = view.findViewById(R.id.editTextStep5);
        editTextStep6 = view.findViewById(R.id.editTextStep6);
        editTextStep7 = view.findViewById(R.id.editTextStep7);
        editTextStep8 = view.findViewById(R.id.editTextStep8);
        editTextStep9 = view.findViewById(R.id.editTextStep9);
        editTextStep10 = view.findViewById(R.id.editTextStep10);
        editTextStep11 = view.findViewById(R.id.editTextStep11);
        editTextStep12 = view.findViewById(R.id.editTextStep12);
        editTextStep13 = view.findViewById(R.id.editTextStep13);
        editTextStep14 = view.findViewById(R.id.editTextStep14);
        editTextStep15 = view.findViewById(R.id.editTextStep15);
        editTextStep16 = view.findViewById(R.id.editTextStep16);
        editTextStep17 = view.findViewById(R.id.editTextStep17);
        editTextStep18 = view.findViewById(R.id.editTextStep18);
        editTextStep19 = view.findViewById(R.id.editTextStep19);
        editTextStep20 = view.findViewById(R.id.editTextStep20);

        btnAddRecipe = view.findViewById(R.id.button);

        btnAddRecipe.setOnClickListener(v -> {
            addInSharedPreference();
        });
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private void addInSharedPreference() {
        addDataIntoList();

        modelList = new ArrayList<>();

        modelList.add(new Recipe(name, size, ingredientsList, recipeStepsList));
        dataBaseService.AddRecipe(modelList);
        Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show();

        clearData();
        addDataIntoList();
        modelList.add(new Recipe(name, size, ingredientsList, recipeStepsList));
        Utilities.clearSharedPref(context);
        saveDataStatus = true;
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public void addDataIntoList() {
        recipe1 = editText1.getText().toString();
        recipe2 = editText2.getText().toString();
        recipe3 = editText3.getText().toString();
        recipe4 = editText4.getText().toString();
        recipe5 = editText5.getText().toString();
        recipe6 = editText6.getText().toString();
        recipe7 = editText7.getText().toString();
        recipe8 = editText8.getText().toString();
        recipe9 = editText9.getText().toString();
        recipe10 = editText10.getText().toString();
        recipe11 = editText11.getText().toString();
        recipe12 = editText12.getText().toString();
        recipe13 = editText13.getText().toString();
        recipe14 = editText14.getText().toString();
        recipe15 = editText15.getText().toString();
        recipe16 = editText16.getText().toString();
        recipe17 = editText17.getText().toString();
        recipe18 = editText18.getText().toString();
        recipe19 = editText19.getText().toString();
        recipe20 = editText20.getText().toString();

        // recipe steps
        recipeStep1 = editTextStep1.getText().toString();
        recipeStep2 = editTextStep2.getText().toString();
        recipeStep3 = editTextStep3.getText().toString();
        recipeStep4 = editTextStep4.getText().toString();
        recipeStep5 = editTextStep5.getText().toString();
        recipeStep6 = editTextStep6.getText().toString();
        recipeStep7 = editTextStep7.getText().toString();
        recipeStep8 = editTextStep8.getText().toString();
        recipeStep9 = editTextStep9.getText().toString();
        recipeStep10 = editTextStep10.getText().toString();
        recipeStep11 = editTextStep11.getText().toString();
        recipeStep12 = editTextStep12.getText().toString();
        recipeStep13 = editTextStep13.getText().toString();
        recipeStep14 = editTextStep14.getText().toString();
        recipeStep15 = editTextStep15.getText().toString();
        recipeStep16 = editTextStep16.getText().toString();
        recipeStep17 = editTextStep17.getText().toString();
        recipeStep18 = editTextStep18.getText().toString();
        recipeStep19 = editTextStep19.getText().toString();
        recipeStep20 = editTextStep20.getText().toString();


        addDataIngredientsList();
        addDataInReceipeStepsList();

        name = nameEditText.getText().toString();
        if (!sizeEditText.getText().toString().isEmpty()) {
            size = Integer.valueOf(sizeEditText.getText().toString());
        }
    }

    public void clearData() {
        nameEditText.setText("");
        sizeEditText.setText("");
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        editText6.setText("");
        editText7.setText("");
        editText8.setText("");
        editText9.setText("");
        editText10.setText("");
        editText11.setText("");
        editText12.setText("");
        editText13.setText("");
        editText14.setText("");
        editText15.setText("");
        editText16.setText("");
        editText17.setText("");
        editText18.setText("");
        editText19.setText("");
        editText20.setText("");

        // recipe steps
        editTextStep1.setText("");
        editTextStep2.setText("");
        editTextStep3.setText("");
        editTextStep4.setText("");
        editTextStep5.setText("");
        editTextStep6.setText("");
        editTextStep7.setText("");
        editTextStep8.setText("");
        editTextStep9.setText("");
        editTextStep10.setText("");
        editTextStep11.setText("");
        editTextStep12.setText("");
        editTextStep13.setText("");
        editTextStep14.setText("");
        editTextStep15.setText("");
        editTextStep16.setText("");
        editTextStep17.setText("");
        editTextStep18.setText("");
        editTextStep19.setText("");
        editTextStep20.setText("");
    }

    public void showData() {
        Recipe recipe = modelList.get(0);
        nameEditText.setText(recipe.getRecipe());
        sizeEditText.setText(recipe.getDishSize() + "");
        editText1.setText(recipe.getIngredientsList().get(0));
        editText2.setText(recipe.getIngredientsList().get(1));
        editText3.setText(recipe.getIngredientsList().get(2));
        editText4.setText(recipe.getIngredientsList().get(3));
        editText5.setText(recipe.getIngredientsList().get(4));
        editText6.setText(recipe.getIngredientsList().get(5));
        editText7.setText(recipe.getIngredientsList().get(6));
        editText8.setText(recipe.getIngredientsList().get(7));
        editText9.setText(recipe.getIngredientsList().get(8));
        editText10.setText(recipe.getIngredientsList().get(9));
        editText11.setText(recipe.getIngredientsList().get(10));
        editText12.setText(recipe.getIngredientsList().get(11));
        editText13.setText(recipe.getIngredientsList().get(12));
        editText14.setText(recipe.getIngredientsList().get(13));
        editText15.setText(recipe.getIngredientsList().get(14));
        editText16.setText(recipe.getIngredientsList().get(15));
        editText17.setText(recipe.getIngredientsList().get(16));
        editText18.setText(recipe.getIngredientsList().get(17));
        editText19.setText(recipe.getIngredientsList().get(18));
        editText20.setText(recipe.getIngredientsList().get(19));

        // recipe steps
        editTextStep1.setText(recipe.getStepsList().get(0));
        editTextStep2.setText(recipe.getStepsList().get(1));
        editTextStep3.setText(recipe.getStepsList().get(2));
        editTextStep4.setText(recipe.getStepsList().get(3));
        editTextStep5.setText(recipe.getStepsList().get(4));
        editTextStep6.setText(recipe.getStepsList().get(5));
        editTextStep7.setText(recipe.getStepsList().get(6));
        editTextStep8.setText(recipe.getStepsList().get(7));
        editTextStep9.setText(recipe.getStepsList().get(8));
        editTextStep10.setText(recipe.getStepsList().get(9));
        editTextStep11.setText(recipe.getStepsList().get(10));
        editTextStep12.setText(recipe.getStepsList().get(11));
        editTextStep13.setText(recipe.getStepsList().get(12));
        editTextStep14.setText(recipe.getStepsList().get(13));
        editTextStep15.setText(recipe.getStepsList().get(14));
        editTextStep16.setText(recipe.getStepsList().get(15));
        editTextStep17.setText(recipe.getStepsList().get(16));
        editTextStep18.setText(recipe.getStepsList().get(17));
        editTextStep19.setText(recipe.getStepsList().get(18));
        editTextStep20.setText(recipe.getStepsList().get(19));
    }

    @Override
    public void onStart() {
        modelList = new ArrayList<>();
        modelList = Utilities.getList(context, "recipeList");
        if (modelList != null) {
            modelList = Utilities.getList(context, "recipeList");
            showData();
        }
        super.onStart();
    }

    @SuppressLint("NewApi")
    @Override
    public void onPause() {
        if (!saveDataStatus) {
            List<Recipe> modelList1 = Utilities.getList(context, "recipeList");
            modelList1 = new ArrayList<>();
            if (modelList1 == null) {
                modelList1 = new ArrayList<>();
            }
            addDataIntoList();
            modelList1.add(new Recipe(name, size, ingredientsList, recipeStepsList));
            Utilities.saveList(context, modelList1, "recipeList");
        }
        super.onPause();
    }


    private void addDataIngredientsList() {
        for (int i = 0; i < 20; i++) {
            switch (i) {
                case 0:
                    ingredientsList.add(i, recipe1);
                    break;
                case 1:
                    ingredientsList.add(i, recipe2);
                    break;
                case 2:
                    ingredientsList.add(i, recipe3);
                    break;
                case 3:
                    ingredientsList.add(i, recipe4);
                    break;
                case 4:
                    ingredientsList.add(i, recipe5);
                    break;
                case 5:
                    ingredientsList.add(i, recipe6);
                    break;
                case 6:
                    ingredientsList.add(i, recipe7);
                    break;
                case 7:
                    ingredientsList.add(i, recipe8);
                    break;
                case 8:
                    ingredientsList.add(i, recipe9);
                    break;
                case 9:
                    ingredientsList.add(i, recipe10);
                    break;
                case 10:
                    ingredientsList.add(i, recipe11);
                    break;
                case 11:
                    ingredientsList.add(i, recipe12);
                    break;
                case 12:
                    ingredientsList.add(i, recipe13);
                    break;
                case 13:
                    ingredientsList.add(i, recipe14);
                    break;
                case 14:
                    ingredientsList.add(i, recipe15);
                    break;
                case 15:
                    ingredientsList.add(i, recipe16);
                    break;
                case 16:
                    ingredientsList.add(i, recipe17);
                    break;
                case 17:
                    ingredientsList.add(i, recipe18);
                    break;
                case 18:
                    ingredientsList.add(i, recipe19);
                    break;
                case 19:
                    ingredientsList.add(i, recipe20);
                    break;
            }
        }
    }

    private void addDataInReceipeStepsList() {
        for (int i = 0; i <= 20; i++) {
            switch (i) {
                case 0:
                    recipeStepsList.add(i, recipeStep1);
                    break;
                case 1:
                    recipeStepsList.add(i, recipeStep2);
                    break;
                case 2:
                    recipeStepsList.add(i, recipeStep3);
                    break;
                case 3:
                    recipeStepsList.add(i, recipeStep4);
                    break;
                case 4:
                    recipeStepsList.add(i, recipeStep5);
                    break;
                case 5:
                    recipeStepsList.add(i, recipeStep6);
                    break;
                case 6:
                    recipeStepsList.add(i, recipeStep7);
                    break;
                case 7:
                    recipeStepsList.add(i, recipeStep8);
                    break;
                case 8:
                    recipeStepsList.add(i, recipeStep9);
                    break;
                case 9:
                    recipeStepsList.add(i, recipeStep10);
                    break;
                case 10:
                    recipeStepsList.add(i, recipeStep11);
                    break;
                case 11:
                    recipeStepsList.add(i, recipeStep12);
                    break;
                case 12:
                    recipeStepsList.add(i, recipeStep13);
                    break;
                case 13:
                    recipeStepsList.add(i, recipeStep14);
                    break;
                case 14:
                    recipeStepsList.add(i, recipeStep15);
                    break;
                case 15:
                    recipeStepsList.add(i, recipeStep16);
                    break;
                case 16:
                    recipeStepsList.add(i, recipeStep17);
                    break;
                case 17:
                    recipeStepsList.add(i, recipeStep18);
                    break;
                case 18:
                    recipeStepsList.add(i, recipeStep19);
                    break;
                case 19:
                    recipeStepsList.add(i, recipeStep20);
                    break;
            }
        }
    }
}