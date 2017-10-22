package com.example.tyler.cookbook;

import android.os.Parcelable;

import java.util.ArrayList;
import android.os.Parcel;
import java.util.Scanner;

/**
 * Created by joshuabump on 10/20/17.
 */

public class Recipe{



    private int cookingTime;
    private String recipeName;
    private ArrayList<String> ingredients;
    private int servingSize;
    private String instructions;



    public Recipe(String instruct, int cTime, String rName, String ingrStr, int sSize) {
        instructions=instruct;
        cookingTime=cTime;
        recipeName=rName;
        Scanner scanner = new Scanner(ingrStr);
        scanner.useDelimiter(",");
        ingredients = new ArrayList<String>();
       while(scanner.hasNext())
        {
            //add each item  to an array list
            ingredients.add(scanner.next());
        }
        scanner.close();
        servingSize=sSize;
    }
    public Recipe(){}

    /**
     * returns the Recipe name
     * @return recipeName
     */
    public String getRecipeName() {return recipeName;}

    public int getCookingTime() {return cookingTime;}

    public ArrayList<String> getIngredients() {return ingredients;}

    public int getServingSize() {return servingSize;}

    /**
     * Tells if this recipe contains or uses a specified ingredient
     * @param chosenIngredient
     * @return true if the ingredient is used, false if the recipe does not
     */
    public boolean containsIngredient(String chosenIngredient) {
        if(chosenIngredient.isEmpty() || chosenIngredient == null) return false;
        for(int i=0;i<ingredients.size();i++) {

            if (ingredients.get(i).toLowerCase().contains(chosenIngredient.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean overallTime(int wantedTime) {
        if(cookingTime<=wantedTime  || wantedTime == -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean servingSize(int minPeople,int maxPeople) {
        if(minPeople>maxPeople) return false;
        if((servingSize>=minPeople && servingSize<=maxPeople) || (minPeople==0 && maxPeople ==0) ){
            return true;
        }
        else {
            return false;
        }
    }

}