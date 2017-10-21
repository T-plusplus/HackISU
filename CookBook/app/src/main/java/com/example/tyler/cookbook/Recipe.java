package com.example.tyler.cookbook;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by joshuabump on 10/20/17.
 */

public class Recipe {



    private String cookingTime;
    private String recipeName;
    private ArrayList<String> ingredients;
    private int servingSize;



    public Recipe(String cTime, String rName, ArrayList<String> ing, int sSize) {
        cookingTime=cTime;
        recipeName=rName;
        ingredients=ing;
        servingSize=sSize;


    }

    public String getRecipeName() {

        return recipeName;
    }

    public String getCookingTime() {

        return cookingTime;
    }

    public ArrayList<String> getIngredients() {

        return ingredients;
    }

    public int getServingSize() {

        return servingSize;
    }

    public boolean containsIngredient() {

        new scanner = Scanner(System.in);

        String chosenIngredient;

        int arrayLength=ingredients.length();

        for(int i=0;i<arrayLength;i++) {

            if (ingredients(i)==chosenIngredient) {

                return true;
            }

            }
        }

    }

