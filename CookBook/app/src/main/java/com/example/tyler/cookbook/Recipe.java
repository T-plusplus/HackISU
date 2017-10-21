package com.example.tyler.cookbook;

import java.util.ArrayList;

/**
 * Created by joshuabump on 10/20/17.
 */

public class Recipe {



    private String cookingTime;
    private String recipeName;
    private ArrayList<String> ingredients;
    private int servingSize;



    public Recipe(String cTime, String rName, String ingrStr, int sSize) {
        cookingTime=cTime;
        recipeName=rName;
        String[] ingrArr=ingrStr.split("%");
        for(int dex=0; dex<ingrArr.length; dex++)
        {
            //add each item  to an array list
            ingredients.add(ingrArr[dex]);
        }
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

    public boolean containsIngredient(String chosenIngredient) {

        int arrayLength=ingredients.size();

        for(int i=0;i<arrayLength;i++) {

            if (ingredients.get(i)==chosenIngredient) {

                return true;
            }

            }
            return false;
        }


    }

