package com.example.myRecipes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddRecipe extends Fragment {
    private AddRecipesListener listener;
    String name;
    Integer size;
    String recipe1, recipe2, recipe3, recipe4, recipe5, recipe6, recipe7, recipe8, recipe9, recipe10, recipe11, recipe12, recipe13, recipe14, recipe15, recipe16, recipe17, recipe18, recipe19, recipe20;
    String recipeStep1, recipeStep2, recipeStep3, recipeStep4, recipeStep5, recipeStep6, recipeStep7, recipeStep8, recipeStep9, recipeStep10, recipeStep11, recipeStep12, recipeStep13, recipeStep14, recipeStep15, recipeStep16, recipeStep17, recipeStep18, recipeStep19, recipeStep20;
    Activity context;
    List<Recipe> modelList;
    List<String> ingredientsList;
    List<String> recipeStepsList;

    public AddRecipe() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        try {
            this.listener = (AddRecipesListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("the class " +
                    getActivity().getClass().getName() +
                    " must implements the interface 'AddRecipesListener'");
        }

        super.onAttach(context);
    }

    EditText nameEditText, sizeEditText, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20;
    EditText editTextStep1, editTextStep2, editTextStep3, editTextStep4, editTextStep5, editTextStep6, editTextStep7, editTextStep8, editTextStep9, editTextStep10, editTextStep11, editTextStep12, editTextStep13, editTextStep14, editTextStep15, editTextStep16, editTextStep17, editTextStep18, editTextStep19, editTextStep20;
    Button btnAddRecipe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_recipes, container, false);
        context = getActivity();

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

    private void addInSharedPreference() {
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
        size = Integer.valueOf(sizeEditText.getText().toString());


        modelList = Utilities.getList(context, "recipeList");
        if (modelList == null) {
            modelList = new ArrayList<>();
        }
        modelList.add(new Recipe(name, size, ingredientsList, recipeStepsList));
        Utilities.saveList(context, modelList, "recipeList");

        Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public interface AddRecipesListener {

    }
}