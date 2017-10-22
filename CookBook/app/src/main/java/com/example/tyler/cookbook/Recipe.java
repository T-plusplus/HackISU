package com.example.tyler.cookbook;

import java.util.ArrayList;

/**
 * Created by joshuabump on 10/20/17.
 */

public class Recipe {



    private int cookingTime;
    private String recipeName;
    private ArrayList<String> ingredients;
    private int servingSize;
    private String instructions;



    public Recipe(String instruct, int cTime, String rName, String ingrStr, int sSize) {
        instructions=instruct;
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

    /**
     * returns the Recipe name
     * @return recipeName
     */
    public String getRecipeName() {

        return recipeName;
    }

    public int getCookingTime() {

        return cookingTime;
    }

    public ArrayList<String> getIngredients() {

        return ingredients;
    }

    public int getServingSize() {

        return servingSize;
    }

    /**
     * Tells if this recipe contains or uses a specified ingredient
     * @param chosenIngredient
     * @return true if the ingredient is used, false if the recipe does not
     */
    public boolean containsIngredient(String chosenIngredient) {

        for(int i=0;i<ingredients.size();i++) {

            if (ingredients.get(i).toLowerCase().contains(chosenIngredient.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean overallTime(int wantedTime) {

        if(cookingTime<=wantedTime) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean servingSize(int minPeople,int maxPeople) {

        if(servingSize>=minPeople && servingSize<=maxPeople) {
            return true;
        }
        else {
            return false;
        }
    }


}